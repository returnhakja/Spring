package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.istack.internal.logging.Logger;

import sun.rmi.log.LogOutputStream;

@Controller
public class URLTemplateController {
	
	
	//http://localhost:8080/mvc/urlTest.do
//	@GetMapping(value = "urlTest.do")
//	public String urlTest1() {
//		return "view";
//	}
	
	
	// http://localhost:8080/mvc/urlTest.do/1 로 넘겨줄꺼면?
//	@GetMapping(value = "urlTest.do/{id}") //1이 자연스레 id로 들어갈거임
//	public String urlTest1(@PathVariable String id) {
//		System.out.println("value - " + id);
		
//		return "forward:../view.jsp";
		/*forward를 사용하기 위해서는 컨트롤러랑 같은 위치에 있게 만들어 줘야한다 
		url 값이 바뀌지않음
		
		*/
//	}	
	
	//Model API 활용하기
//	http://localhost:8080/mvc/urlTest.do/1/home/27 -> id/age --> view.jsp
	
	@GetMapping(value = "urlTest.do/{id}/home/{age}")
	public String urlTest2(@ModelAttribute("id") String id, @ModelAttribute("age") String age , Model model) {
		
		System.out.println(id + " " + age);
	
//		return "forward:../../../view.jsp";	// 상대경로
		return "forward:/view.jsp";			// 절대경로
	}
	
	
//	@GetMapping(value = "urlTest.do/{id}/home/{age}")
//	public String urlTest2(@ModelAttribute String id, @ModelAttribute String age , Model model) {
//	model.addAttribute("id" ,id);
//	model.addAttribute("age" ,age);
//	return "forward:/view.jsp";			// 절대경로
//}	
		

}
