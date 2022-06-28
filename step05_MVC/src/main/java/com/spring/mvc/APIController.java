package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.domain.Customer;

@Controller
public class APIController {
	
	//id, age로 파라미터 전송하는 web query 데이터 처리
	
	@RequestMapping("getData1.do")
	public ModelAndView getOne(@RequestParam("id") String id, @RequestParam("age") int age) {
		System.out.println(id+ " " + age);
		ModelAndView model = new ModelAndView();
		
		// view (ModelAndView로 값을 넘겨줄수있음)
		model.setViewName("view2");
		return model;
		
		
	}
	
	
	/*
	 * Model API
	 * Model 클래스는 getParameter로 추출 할 수 없는 데이터를 
	 * request 객체에 저장되고자 할 때 사용 가능한 객체 
	 * model.addAttribute() = request.setAttribute() 와 같다
	 * 
	 */
	
	@RequestMapping("getData2.do")
	public String getTwo(Model model, Customer customer) {
		System.out.println(customer);
		
		
		// view
		model.addAttribute("msg", "집에가자");
//		model.addAttribute("name", customer.getName());
//		model.addAttribute("age", customer.getAge());
		
		//비효율적임 객체로 만들어주삼
		model.addAttribute("customer", customer);
		return "view2";
	}
	
	
	/*	 java code 
	 * Customer customer = new Customer("busan", 29); 
	 * request.setAttribute("customer", customer);
	 * 이것을 한방에 해결해줄 친구가 ModelAttribute이다
	 */
	// 바로 view2로 넘어감
	@GetMapping(value = "getData3.do")
	public String getThree(@ModelAttribute("customer") Customer customer) {
	
		return "view2";
	}
	
	// 예외처리 확인을 위한 test 메소드 
	@GetMapping(value = "getData4.do")
	public String getFour() throws Exception {
		if(true) {
			throw new Exception("URL Exception");
		}
		return null;
	}
	
	@ExceptionHandler
	public String exceptionHandling(Exception e) {
		return "redirect:failView.jsp?msg=" + e.getMessage();
		/* redirect를 하게되면 파일 경로의 기준이 web-app이 된다 */
	}
	
	
	
	
	
}
