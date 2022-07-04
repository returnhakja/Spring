package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import model.domain.Customer;


@Controller
//@RequestMapping("session") �̰� ���ָ� �����Ҷ� session ����Ǵ� �κ��� �Ƚᵵ�� �⺻���� ��������
@SessionAttributes({"job","id","age", "customer"})

public class SessionController {
	
	//Cookie ����
	@GetMapping(value = "/cookieTest.do")
//	public String cookieTest(@CookieValue String id) {
	public String cookieTest(@CookieValue("id") String ids) { // �������� ���� ��Ī�� �ٿ��� ����ϸ� ����
		System.out.println("Cookie :" + ids);
		
		return "redirect:/cookieView.jsp";	
	}
	
	//Session ����
//	@GetMapping(value ="session/sessionTest1.do")
	@GetMapping(value ="sessionTest1.do")
	public String SessionTest1(HttpSession session) {
		System.out.println(session.getAttribute("id")); //id�� �Ѿ������ Ȯ��
		session.setAttribute("job", "programmer"); //�����߰�
		return "redirect:/sessionView1.jsp";
	}
	
	//job session ������ ����
	@GetMapping(value ="session/jobDelete.do")
	public String jobDelete(@ModelAttribute("job") String job, SessionStatus status) {
//		System.out.println("jobDelete.do :" + job);
		
		status.setComplete(); //session ��ȿȭ �޼ҵ�
		return "redirect:/sessionView1.jsp";
	}
	@GetMapping(value = "session/sessionDelete.do")
	public String Delete(@ModelAttribute("id") String id,@ModelAttribute("age") String age, SessionStatus status) {
		status.setComplete(); //session ��ȿȭ �޼ҵ�
		return "redirect:/sessionView1.jsp";
	} //�̷����ϸ� �ѹ��� job������ �������� �ѹ��� ������ �ȴ�
	
	@GetMapping("session/sessionTest2.do")
	public String sessionTest2DTO(Model model, Customer customer) {
		System.out.println(customer);
		model.addAttribute("customer", customer);
		return "redirect:/sessionView2.jsp";
	}
	
	// customer session ������ ����
		@GetMapping(value ="session/customerDelete.do")
		public String sessionCustomerDelete(SessionStatus status) {
			
			status.setComplete(); //session ��ȿȭ �޼ҵ�
			return "redirect:/sessionView2.jsp";
		}
		
		
		
	@GetMapping(value = "session/loginForm.do")	
	public String moveLoginForm() {
		return "loginForm";
	}
	
//	@RequestMapping(value = "session/login.do", method= RequestMethod.POST)
	@PostMapping(value ="session/login.do")
	public String login(@RequestParam("password") String password, HttpSession session) {
		//���� : pw�� 1234 �϶�, admin ����
		// ���� �ƴ϶�� ,index.jsp ȭ�� ��ȯ
		if(password.equals("1234")) {
			session.setAttribute("isAdmin", "true");
		}else {
			System.out.println("??");
			return "redirect:/loginForm";
		}
		return "redirect:/";
	}
	
	@RequestMapping("session/logout.do")
	public String logout(HttpSession session) {
		//index.jsp�� �α׾ƿ� ��ư Ŭ���� 
		//�ش� ������ ���� �� -> index.jsp�� ȭ�� ��ȯ
		session.removeAttribute("isAdmin");
		return "redirect:/";
	}
	
}
