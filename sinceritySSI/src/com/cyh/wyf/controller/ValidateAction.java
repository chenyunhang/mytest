package com.cyh.wyf.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/validate")
public class ValidateAction {
	
	
	@RequestMapping("/vali")
	public String  validateTest(){
		
			
	//	return "/vali/demo01.jsp";
	//	return "/vali/demo02.jsp";
	//	return "/vali/demo03.jsp";
	//  return "/vali/demo04.jsp";
	//	return "/vali/demo05.jsp";
		return "/vali/terminal.jsp";
	}
	
	@RequestMapping("/valid")
	public void valiUser(String sname,HttpServletResponse response){
		String uname = sname;
	
		if ("admin".equals(uname)) {
			
			  try {
				response.getWriter().print(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				response.getWriter().print(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
	}
}