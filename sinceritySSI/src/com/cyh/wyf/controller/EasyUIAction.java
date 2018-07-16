package com.cyh.wyf.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyh.wyf.biz.EasyUIBiz;
import com.cyh.wyf.biz.UserBiz;
import com.cyh.wyf.biz.XzqhBiz;
import com.cyh.wyf.entity.TArea;
import com.cyh.wyf.entity.TCity;
import com.cyh.wyf.entity.TProvince;
import com.cyh.wyf.entity.TUser;

import net.sf.json.JSONArray;




@Controller
@RequestMapping("/easyui")
public class EasyUIAction {
	@Autowired
	private EasyUIBiz easyUIBiz;
	

	@Autowired
	private UserBiz userBiz;
	
	@Autowired
	private XzqhBiz xzqhBiz;
	
	@RequestMapping("/province")
	public void getAllCity(HttpServletResponse response){
			try {
				List<TProvince>	province = xzqhBiz.getAllProvince();				
				JSONArray json = JSONArray.fromObject(province); 
				
				System.out.println(json);
				response.setContentType("text/html;charset=UTF-8");  
				response.getWriter().print(json);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
	}

	@RequestMapping("/city")
	public void getAllCity(String code_p,HttpServletResponse response){
			try {
				List<TCity>	city = xzqhBiz.getAllCity(code_p);
				JSONArray json = JSONArray.fromObject(city); 
				System.out.println(json);
				response.setContentType("text/html;charset=UTF-8");  
				response.getWriter().print(json);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
	}
	 
	@RequestMapping("/area")
	public void getAllArea(String code_c,HttpServletResponse response){
		try {
			List<TArea>	area = xzqhBiz.getAllArea(code_c);				
			JSONArray json = JSONArray.fromObject(area); 
			System.out.println(json);
			
			response.setContentType("text/html;charset=UTF-8");  
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	
	
	
	/**
	 * 删除用户
	 * @return
	 */
	@RequestMapping("/delUser")
	@ResponseBody
	public int delUser(HttpServletRequest request){
		int flag = 0;
		String result = null;
		Map userMap  = new HashMap();
		userMap.put("id", request.getParameter("id"));
		
		
		try {
			easyUIBiz.delUser(userMap);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	/**
	 * 修改用户
	 * @return
	 */
	@RequestMapping("/editUser")
	@ResponseBody
	public int editUser(HttpServletRequest request){
		int flag = 2;
		String result = null;
		Map userMap  = new HashMap();
		userMap.put("id", request.getParameter("id"));
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
		
		try {
			easyUIBiz.editUser(userMap);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	
	/**
	 * 增加用户
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public int addUser(HttpServletRequest request){
		int flag = 0;
		String result = null;
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
		
		try {
			userBiz.regist(userMap);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 返回用户列表
	 * @return
	 */
	@RequestMapping("/userlist")
	@ResponseBody
	public List<TUser> getUserList(){
		List<TUser> userList = null;
		
		try {
			userList = easyUIBiz.getAllUser(); 
			//JSONArray json = JSONArray.fromObject( userList );
		//	System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	@RequestMapping("/test")
	public String  validateTest(){
	
		return "/easyUI/easyUITest.jsp";
	}
	
	@RequestMapping("/datagrid")
	public String dataGrid(){
		return "/easyUI/datagrid.jsp";
	}
	@RequestMapping("/menuButton")
	public String menuButton(){
		return "/easyUI/menuButton.jsp";
	}
	@RequestMapping("/uploadfy")
	public String uploadfy(){
		return "/easyUI/uploadfy.jsp";
	}
	@RequestMapping("/jsonUtil")
	public String jsonUtil(){
		return "/easyUI/jsonUtil.jsp";
	}
	
}