package com.cyh.wyf.controller;

import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cyh.wyf.biz.BookBiz;
import com.cyh.wyf.biz.UserBiz;
import com.cyh.wyf.biz.XzqhBiz;
import com.cyh.wyf.entity.TBook;
import com.cyh.wyf.entity.TUser;
import com.cyh.wyf.util.Log;
@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	private UserBiz userBiz;
	
	@Autowired
	private BookBiz bookBiz;
	
	@Autowired
	private XzqhBiz xzqhBiz;
	
	/**
	 * 返回用户列表，转换为json串
	 * @return
	 */
/*	@RequestMapping("/userlist")
	@ResponseBody
	public String getUserList(){
		List<TUser> userList = null;
		
		try {
			userList = userBiz.getUserList(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return JSON.toJSONString(userList);
	    }*/
	@RequestMapping("/userlist")
	public String getUserList(HttpServletRequest request){
		String result = null;
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		// 查询条件Map
		Map userMap  = new HashMap();
		userMap.put("uname", uname);
		userMap.put("pwd", pwd);
		
		try {
		List userList = userBiz.getUserList(userMap); 
			request.setAttribute("userList", userList);
			result = "/back/userlist.jsp";
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
			request.setAttribute("msg", "网络异常，请和管理员联系");	
			result = "/error.jsp";
		}
		
		return result;
	    }
	
	
	/**
	 * ajax异步交互模式参考
	 * @param uname
	 * @param response
	 */
	@RequestMapping("/uservalid")
	public void validUserName(String uname,HttpServletResponse response){		
		
		int iRet = 0;
		try {			
			boolean ifRepeat = userBiz.validUserName(uname);
 			if(ifRepeat){
				 iRet = 1;
 			}
			PrintWriter pw  = response.getWriter();
			pw.println(iRet);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
				
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public String regist(){
		return "/main/regist.jsp";
	}
	
	
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(TUser user,HttpServletRequest request){
		
		
		// 查询条件Map
		Map userMap  = new HashMap();
		userMap.put("uname", request.getParameter("uname"));
		userMap.put("pwd", request.getParameter("pwd"));
		userMap.put("account", request.getParameter("account"));
		userMap.put("sex", request.getParameter("sex"));
		userMap.put("role", 0);
		userMap.put("birth", request.getParameter("birth"));
		userMap.put("province", request.getParameter("province"));
		userMap.put("city", request.getParameter("city"));
		userMap.put("area", request.getParameter("area"));
		userMap.put("email", request.getParameter("email"));
		
		String result ;
		try {
			userBiz.regist(userMap);	
			request.setAttribute("msg","用户注册成功,请重新登录!");
			result = "/main/login.jsp";
		} catch (SQLIntegrityConstraintViolationException e) {
			if(e.getSQLState().equals("23000")){
				request.setAttribute("msg", "用户名冲突了，请修改");	
				result = "/main/regist.jsp";
			}else{
				request.setAttribute("msg", "网络异常，请和管理员联系");	
				result = "/error.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "网络异常，请和管理员联系");	
			result = "/error.jsp";
		}
		
		return result;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){

		return "/main/login.jsp";
	}
	
	@RequestMapping(value="/login",method= RequestMethod.POST)
	public String login(String uname,String pwd,HttpServletRequest request){
		String result = null;
		if (uname != null && pwd != null && !uname.equals("") && !pwd.equals("")) {
			try {
				TUser user = userBiz.login(uname, pwd);
				if (user != null) {
					//用户登录成功了
					request.getSession().setAttribute("user", user);
					result = "forward:/book/main.do";
				}else {
					request.setAttribute("msg", "用户名、或密码错误，请检查");
					result = "/main/login.jsp";
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "网络异常，请和管理员联系");
			}
			
		}else {
			request.setAttribute("msg", "用户名或密码，不能为空");
			result = "/main/login.jsp";
		}
		
		return result;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/book/main.do";
	}
	
	@RequestMapping("/addshopcar")
	public String addShopCar(String isbn,HttpServletRequest request){
		String result = "";
		
		if(isbn != null){
			//先判断当前用户是否已经登录
			if(request.getSession().getAttribute("user") != null){
				Object object = request.getSession().getAttribute("ShopCar");
				if(object == null){
					Map<String,Integer> shopCar = new HashMap<String,Integer>();
					shopCar.put(isbn,1);
					request.getSession().setAttribute("ShopCar",shopCar);					
				}else{
					Map<String,Integer> shopCar = (Map<String,Integer>)object;
					shopCar.put(isbn,1);
				}				
				result ="forward:/user/showshopcar.do";
			}else{
				//没有登录
				result = "/main/login.jsp";
			}
			
		}else{
			request.setAttribute("msg", "网络异常，请和管理员联系");	
			result = "/error.jsp";
		}
		
		return result;
		
	}
	
	@RequestMapping("/showshopcar")
	public String showShopBooks(HttpServletRequest request){
		String result = "";
		
		if(request.getSession().getAttribute("user") != null){  
			Object object = request.getSession().getAttribute("ShopCar");
	         if(object != null){
	        	 Map<String,Integer> isbns =  (Map<String,Integer>)object; 
	            try {
	        		 List<TBook> books = bookBiz.getBooks(isbns.keySet());
	        		 request.setAttribute("books",books);
	        		 result = "/main/ShopCar.jsp";
				} catch (Exception e) {
					Log.logger.error(e.getMessage());
					request.setAttribute("msg", "网络异常，请和管理员联系");	
					result = "/error.jsp";
				}        	 
	        	 
	         }else{
	        	 result = "/main/ShopCar.jsp";
	         }
		}else{
			request.setAttribute("msg","你访问了受限页面，请先登录");
			result = "/main/login.jsp";
		}         	
		
		return result;
	}
	
	@RequestMapping("/checkout")
	public String checkout(HttpServletRequest request){
		String result;
		
		if(request.getSession().getAttribute("user") != null){                 //先判断用户是否已经登录
			Object object = request.getSession().getAttribute("ShopCar");
			if(object != null){
				Map<String,Integer> isbns = (Map<String,Integer>)object;
				try {
					List<TBook> books = bookBiz.getBooks(isbns.keySet());
					for(TBook book : books){
						String value = request.getParameter(book.getIsbn());
						int bookCount = 1;
						try {
							if(value != null && !value.trim().equals("")){
								bookCount = Integer.parseInt(value);
								book.setBuyCount(bookCount);                   //存储购买数量
								isbns.put(book.getIsbn(),bookCount);           //把书的购买数量，存储到了Session中
							}						
						} catch (Exception e) {
							Log.logger.error("购买图书的数量应该为整数:" + e.getMessage());
						}
					}
					double allMoney = 0;
					for(TBook bk : books){
						allMoney = allMoney + bk.getPrice()*bk.getBuyCount(); 
					}
					request.setAttribute("books", books);
					request.setAttribute("allMoney",allMoney);
					result = "/main/Checkout.jsp";
					
				} catch (Exception e) {
					request.setAttribute("msg", "网络异常，请和管理员联系");	
					result = "/error.jsp";
				}
			}else{
					request.setAttribute("msg", "网络异常，请和管理员联系");	
					result = "/error.jsp";
				}			
		}else{
			request.setAttribute("msg","你访问了受限页面，请先登录");
			result = "/main/login.jsp";
		}
		
		return result;
		
	}
	
	@RequestMapping(value="/paymoney",method=RequestMethod.GET)
	public String payMoney(){
		return "/main/PaySuccess.jsp";
	}
	
	
	@RequestMapping(value="/paymoney",method=RequestMethod.POST)
	public String payMoney(HttpServletRequest request){
		String result ;
		
		if(request.getSession().getAttribute("user") != null){          
			String value = request.getParameter("allMoney");
			if(value != null){
				double allMoney = Double.parseDouble(value);
				TUser user = (TUser)request.getSession().getAttribute("user");
				Map<String,Integer> car =  (Map<String,Integer>)request.getSession().getAttribute("ShopCar");
				try {
					userBiz.buyBooks(user.getUname(), allMoney,car);
					car.clear();				
					String path = request.getContextPath();
					String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					result = "redirect:/user/paymoney.do";
				} catch (Exception e) {
					request.setAttribute("msg", "网络异常，请和管理员联系");	
					result = "/error.jsp";
				}			
			}else{
				request.setAttribute("msg", "网络异常，请和管理员联系");	
				result = "/error.jsp";
			}
		}else{
			request.setAttribute("msg","你访问了受限页面，请先登录");
			result = "/main/login.jsp";
		}
		
		return result;
	}
}
