package com.spring.common;

public class loginNoticeAspect {
	
	//�α��� ������ ���� �������
	public void noticeLoginUser(Object name) {
		if(name != null) {
			System.out.println(name + "����");
		}
	}
	
	// �α��� ���н� ����Ǵ� ���� ����
	public void noticeLoginExcepetion(Exception exception) {
		System.out.println("�߻��� ���� :" + exception.getMessage());
	}
}

