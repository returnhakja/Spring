package com.spring.aop;


// �α��� �Ҷ� ����ϴ� Ŭ����
public class User {	
	public String login(String user) throws Exception {
		String name = null;
		
		if("test".equals(user) || "admin".equals(user)) {
			name = user;
		}else {
			throw new Exception("���̵� Ȯ���ϼ���");
		}
		
		return name;
	}
}
