package com.cyh.wyf.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cyh.wyf.biz.BookBiz;
import com.cyh.wyf.biz.UserBiz;
import com.cyh.wyf.dto.BuyRecord;
import com.cyh.wyf.dto.TurnPage;
import com.cyh.wyf.entity.TBook;
import com.cyh.wyf.util.Log;



@Controller
@RequestMapping("/back")
public class BackAction {
	
	@Autowired
	private BookBiz bookBiz;
	
	@Autowired
	private UserBiz userBiz;
	
	@RequestMapping("/userlistPage")
	public String getUserListPage(){
		return "/back/userlist.jsp";
	}
	
	@RequestMapping(value="/addbook",method=RequestMethod.GET)
	public String addBook(){		
		return "/back/BookAdd.jsp";
		
	}
	
/*	@RequestMapping(value="/addbook",method=RequestMethod.POST)
	public String addBook(TBook book,Model model,@RequestParam MultipartFile pic2 ){
		String result = null;
		if(book != null){			
			try {
				if(pic2 != null && !pic2.isEmpty()){
					book.setPic(pic2.getBytes());
				}				
				bookbiz.addBook(book);
				model.addAttribute("msg",book.getBname() + "--录入成功");
				result = "/back/BookAdd.jsp";
			} catch (Exception e) {
				model.addAttribute("msg", e.getMessage());
				result = "/error.jsp";
			}			
		}		
		
		return result;		
	}
	*/
	@RequestMapping(value="/addbook",method=RequestMethod.POST)
	public String addBook(HttpServletRequest request,@RequestParam MultipartFile pic2 ){
		String result = null;
		Map bookMap = new HashMap();
		bookMap.put("isbn", request.getParameter("isbn"));
		bookMap.put("bname", request.getParameter("bname"));
		bookMap.put("press", request.getParameter("press"));
		bookMap.put("pdate", request.getParameter("pdate"));
		bookMap.put("price", request.getParameter("price"));
		bookMap.put("outline", request.getParameter("outline"));
			try {
								
				bookBiz.addBook(bookMap);
				result = "/back/BookAdd.jsp";
			} catch (Exception e) {
				request.setAttribute("msg", e.getMessage());
				result = "/error.jsp";
			}			
			
		
		return result;		
	}
	
	@RequestMapping(value="/buyrecord")
	public String getBuyRecord(HttpServletRequest request){
		String result ;
		
		int pageNumber = 1;                                            //设置页号的默认值
		String pageNum = request.getParameter("page");
		String uname = request.getParameter("uname");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		Date bDate = null;
		Date eDate = null;
		try {
			SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
			if(beginDate != null && !beginDate.trim().equals("")){
				try {
				    bDate = sd.parse(beginDate);	
				} catch (Exception e) {
					Log.logger.error(e.getMessage());
				}				
			}
			if(endDate != null && !endDate.trim().equals("")){
				try {
				    eDate = sd.parse(endDate);	
				} catch (Exception e) {
					Log.logger.error(e.getMessage());
				}				
			}	
			if(pageNum != null ){
			   try {
				   pageNumber = Integer.parseInt(pageNum);
			   } catch (Exception e) {
				   Log.logger.error(e.getMessage());
			   }	
			}
			TurnPage tp = new TurnPage();
			tp.rowsOnePage = 8;
			if(pageNumber<1)
				pageNumber = 1;			
			tp.currentPage = pageNumber;			
			List<BuyRecord> records = userBiz.getUserBuyRecord(uname,bDate,eDate,tp);
			request.setAttribute("records", records);
			request.setAttribute("uname",uname);
			request.setAttribute("beginDate",beginDate);
			request.setAttribute("endDate",endDate);
			request.setAttribute("CurrentPageNo",tp.currentPage);
			request.setAttribute("maxPageNo", tp.allPages);
			request.setAttribute("RecordAllCount", tp.allRows);
			result = "/back/BuyRecord.jsp";
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
			request.setAttribute("msg", "网络异常，请和管理员联系");	
			result = "/error.jsp";
		}	
		
		return result;		
	}

}
