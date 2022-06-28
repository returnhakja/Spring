<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>view2.jsp</title>
</head>
<body>
<h2>view2 page</h2>
<br><hr>
	1. 요청 객체에 저장된 새로운 데이터 출력 : ${requestScope.msg} <br/>
	2. 요청 객체에 저장된 새로운 데이터 출력 : ${requestScope.customer} <br/>
	3. ${requestScope.customer.name } - ${requestScope.customer.age} 	<!-- 값을 가져오는 것은 getXX로 가져오고 있음 -->
	

</body>
</html>