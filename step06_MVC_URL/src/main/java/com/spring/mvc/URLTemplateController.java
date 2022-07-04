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
	
	
	// http://localhost:8080/mvc/urlTest.do/1 �� �Ѱ��ٲ���?
//	@GetMapping(value = "urlTest.do/{id}") //1�� �ڿ����� id�� ������
//	public String urlTest1(@PathVariable String id) {
//		System.out.println("value - " + id);
		
//		return "forward:../view.jsp";
		/*forward�� ����ϱ� ���ؼ��� ��Ʈ�ѷ��� ���� ��ġ�� �ְ� ����� ����Ѵ� 
		url ���� �ٲ�������
		
		*/
//	}	
	
	//Model API Ȱ���ϱ�
//	http://localhost:8080/mvc/urlTest.do/1/home/27 -> id/age --> view.jsp
	
	@GetMapping(value = "urlTest.do/{id}/home/{age}")
	public String urlTest2(@ModelAttribute("id") String id, @ModelAttribute("age") String age , Model model) {
		
		System.out.println(id + " " + age);
	
//		return "forward:../../../view.jsp";	// �����
		return "forward:/view.jsp";			// ������
	}
	
	
//	@GetMapping(value = "urlTest.do/{id}/home/{age}")
//	public String urlTest2(@ModelAttribute String id, @ModelAttribute String age , Model model) {
//	model.addAttribute("id" ,id);
//	model.addAttribute("age" ,age);
//	return "forward:/view.jsp";			// ������
//}	
		

}
