package com.spring.common;


// 공통안내 로직
public class NoticeAspect {
	// 구매 전 공통 로직
	public void noticeBuyStart() {
		System.out.println("구매할꺼임?");
	}
	
	
	// 구매 후 공통 로직
	public void noticeBuyEnd() {
		System.out.println("구매 완료");
	}
	
	
	// 리턴값이 있는 메소드에만 적용하는 공통 로직
	public void noticeReturnValue(String v) {
		if(v != null) {
			System.out.println("Return 후 처리 로직 : " + v);
		}
	}
	
	// 예외처리를 하는 공통 로직
	public void noticeSellException(Exception exception) {
		System.out.println("발생된 예외 : " + exception.getMessage());
	}
}
