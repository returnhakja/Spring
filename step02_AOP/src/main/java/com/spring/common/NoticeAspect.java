package com.spring.common;


// ����ȳ� ����
public class NoticeAspect {
	// ���� �� ���� ����
	public void noticeBuyStart() {
		System.out.println("�����Ҳ���?");
	}
	
	
	// ���� �� ���� ����
	public void noticeBuyEnd() {
		System.out.println("���� �Ϸ�");
	}
	
	
	// ���ϰ��� �ִ� �޼ҵ忡�� �����ϴ� ���� ����
	public void noticeReturnValue(String v) {
		if(v != null) {
			System.out.println("Return �� ó�� ���� : " + v);
		}
	}
	
	// ����ó���� �ϴ� ���� ����
	public void noticeSellException(Exception exception) {
		System.out.println("�߻��� ���� : " + exception.getMessage());
	}
}
