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
	
	//id, age�� �Ķ���� �����ϴ� web query ������ ó��
	
	@RequestMapping("getData1.do")
	public ModelAndView getOne(@RequestParam("id") String id, @RequestParam("age") int age) {
		System.out.println(id+ " " + age);
		ModelAndView model = new ModelAndView();
		
		// view (ModelAndView�� ���� �Ѱ��ټ�����)
		model.setViewName("view2");
		return model;
		
		
	}
	
	
	/*
	 * Model API
	 * Model Ŭ������ getParameter�� ���� �� �� ���� �����͸� 
	 * request ��ü�� ����ǰ��� �� �� ��� ������ ��ü 
	 * model.addAttribute() = request.setAttribute() �� ����
	 * 
	 */
	
	@RequestMapping("getData2.do")
	public String getTwo(Model model, Customer customer) {
		System.out.println(customer);
		
		
		// view
		model.addAttribute("msg", "��������");
//		model.addAttribute("name", customer.getName());
//		model.addAttribute("age", customer.getAge());
		
		//��ȿ������ ��ü�� ������ֻ�
		model.addAttribute("customer", customer);
		return "view2";
	}
	
	
	/*	 java code 
	 * Customer customer = new Customer("busan", 29); 
	 * request.setAttribute("customer", customer);
	 * �̰��� �ѹ濡 �ذ����� ģ���� ModelAttribute�̴�
	 */
	// �ٷ� view2�� �Ѿ
	@GetMapping(value = "getData3.do")
	public String getThree(@ModelAttribute("customer") Customer customer) {
	
		return "view2";
	}
	
	// ����ó�� Ȯ���� ���� test �޼ҵ� 
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
		/* redirect�� �ϰԵǸ� ���� ����� ������ web-app�� �ȴ� */
	}
	
	
	
	
	
}
