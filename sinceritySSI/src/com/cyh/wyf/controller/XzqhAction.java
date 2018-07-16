package com.cyh.wyf.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyh.wyf.biz.XzqhBiz;
import com.cyh.wyf.entity.TArea;
import com.cyh.wyf.entity.TCity;
import com.cyh.wyf.entity.TProvince;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/xzqh")
public class XzqhAction {
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
	/* @RequestMapping("/test")
		public String test(Model model){
		 String result = null;
			try {
				List<TProvince>	province = xzqhBiz.getAllProvince();				
				model.addAttribute("province",province);
				result = "/main/test.jsp";
				
			} catch (Exception e) {
				model.addAttribute("msg","网络异常，请和管理员联系！！！");
				result = "/error.jsp";
			}
		 return  "/main/test.jsp";
	 }
*/
		 	
	
}
