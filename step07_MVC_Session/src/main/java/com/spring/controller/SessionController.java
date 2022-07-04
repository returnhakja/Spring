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
//@RequestMapping("session") 이거 써주면 매핑할때 session 공통되는 부분은 안써도됌 기본으로 지정해줌
@SessionAttributes({"job","id","age", "customer"})

public class SessionController {
	
	//Cookie 관련
	@GetMapping(value = "/cookieTest.do")
//	public String cookieTest(@CookieValue String id) {
	public String cookieTest(@CookieValue("id") String ids) { // 안정성을 위해 별칭을 붙여서 사용하면 좋음
		System.out.println("Cookie :" + ids);
		
		return "redirect:/cookieView.jsp";	
	}
	
	//Session 관련
//	@GetMapping(value ="session/sessionTest1.do")
	@GetMapping(value ="sessionTest1.do")
	public String SessionTest1(HttpSession session) {
		System.out.println(session.getAttribute("id")); //id값 넘어오는지 확인
		session.setAttribute("job", "programmer"); //세션추가
		return "redirect:/sessionView1.jsp";
	}
	
	//job session 데이터 삭제
	@GetMapping(value ="session/jobDelete.do")
	public String jobDelete(@ModelAttribute("job") String job, SessionStatus status) {
//		System.out.println("jobDelete.do :" + job);
		
		status.setComplete(); //session 무효화 메소드
		return "redirect:/sessionView1.jsp";
	}
	@GetMapping(value = "session/sessionDelete.do")
	public String Delete(@ModelAttribute("id") String id,@ModelAttribute("age") String age, SessionStatus status) {
		status.setComplete(); //session 무효화 메소드
		return "redirect:/sessionView1.jsp";
	} //이렇게하면 한번에 job삭제를 눌렀을때 한번에 삭제가 된다
	
	@GetMapping("session/sessionTest2.do")
	public String sessionTest2DTO(Model model, Customer customer) {
		System.out.println(customer);
		model.addAttribute("customer", customer);
		return "redirect:/sessionView2.jsp";
	}
	
	// customer session 데이터 삭제
		@GetMapping(value ="session/customerDelete.do")
		public String sessionCustomerDelete(SessionStatus status) {
			
			status.setComplete(); //session 무효화 메소드
			return "redirect:/sessionView2.jsp";
		}
		
		
		
	@GetMapping(value = "session/loginForm.do")	
	public String moveLoginForm() {
		return "loginForm";
	}
	
//	@RequestMapping(value = "session/login.do", method= RequestMethod.POST)
	@PostMapping(value ="session/login.do")
	public String login(@RequestParam("password") String password, HttpSession session) {
		//조건 : pw가 1234 일때, admin 인정
		// 만약 아니라면 ,index.jsp 화면 전환
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
		//index.jsp의 로그아웃 버튼 클릭시 
		//해당 세션은 해제 후 -> index.jsp로 화면 전환
		session.removeAttribute("isAdmin");
		return "redirect:/";
	}
	
}
