<%@page import="model.domain.Customer"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Cookie cookie1 = new Cookie("id","test");
	cookie1.setMaxAge(60 * 60);
	response.addCookie(cookie1); //addCookie를 해줘야 적용이 된다
	
	// Customer : String id, int age
	
	session.setAttribute("id", "springsession");
	session.setAttribute("age", 21);
	
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Index.jsp</title>
</head>
<body>
	<h2>Index Page</h2>
	<hr/>
	<h3>Cookie API Test</h3>
	<a href="cookieTest.do">cookieTest.do</a>
	<hr/>
	<h3>Session API Test</h3>
	<a href="session/sessionTest1.do">1. session/sessionTest1.do</a> <br/>
	
	<a href="session/sessionTest2.do?id=spring&age=21">2. session/sessionTest2.do : DTO 객체를 세션에 저장하고 삭제</a>
	
	
	<hr/>
	<h3>로그인 하러 가기</h3>
	<a href="session/loginForm.do"> 로그인하러가기</a>
	<c:if test="${sessionScope.isAdmin=='true'}"> 
	<%-- <c:if test="${sessionScope.isAdmin}">  --%>
	<a href="session/logout.do">로그아웃</a>
	</c:if>
	
	
</body>
</html>