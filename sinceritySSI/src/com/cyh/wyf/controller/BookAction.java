package com.cyh.wyf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyh.wyf.biz.BookBiz;
import com.cyh.wyf.biz.UserBiz;
import com.cyh.wyf.entity.TBook;
import com.cyh.wyf.entity.TProvince;
import com.cyh.wyf.util.Log;

@Controller
@RequestMapping("/book")
public class BookAction {
	
	@Autowired
	private BookBiz bookBiz;
	
	@Autowired
	private UserBiz userBiz;
	
	@RequestMapping("/main")
	public String getAllBooks(Model model){
	String result = null;
	try {
		List<TBook>  books = bookBiz.getAllBooks();
		
		model.addAttribute("books",books);
		result = "/main/main.jsp";
		
	} catch (Exception e) {
		model.addAttribute("msg","网络异常，请和管理员联系！！！");
		result = "/error.jsp";
	}
	return result;
	}
	@RequestMapping("/pic")
	@ResponseBody
	public byte[] getBookpic(@RequestParam("isbn") String isbn,HttpServletRequest request){
		byte[] pic = null;
		if (isbn!= null) {
			try {
				pic = bookBiz.getBookPic(isbn);
			} catch (Exception e) {
				Log.logger.error(e.getMessage()); 
			}
			
		}else {
			request.setAttribute("msg", "网络异常，请和管理员联系！！！");
		}
		return pic;
	}
	@RequestMapping("bookdetail")
	public String getBookDetail(String isbn,HttpServletRequest request){
		String result = "";
		if (isbn != null) {
				try {
					TBook book = bookBiz.getBookDetail(isbn);
					request.setAttribute("book", book);
					result = "/main/BookDetail.jsp";
				} catch (Exception e) {
					Log.logger.error(e.getMessage());
					request.setAttribute("msg", "网络异常，请和管理员联系");	
					result = "/error.jsp";				}
				
		}else {
			request.setAttribute("msg", "网络异常，请和管理员联系");
			result = "/error.jsp";
		}
		return result;
	}

	@RequestMapping("/downfile")
	 public ResponseEntity<byte[]> download(String isbn,HttpServletRequest request) throws IOException { 
		 byte[] pic = null;
		 if(isbn != null){
				try {
					pic = bookBiz.getBookPic(isbn);							
				} catch (Exception e) {
					Log.logger.error(e.getMessage());					
				}				
		  }		  
		  HttpHeaders headers = new HttpHeaders(); 
		  headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
		  headers.setContentDispositionFormData("attachment", isbn + ".jpg"); 
		  return new ResponseEntity<byte[]>(pic, headers, HttpStatus.CREATED); 
      }
	 
	
		 	
	
}
