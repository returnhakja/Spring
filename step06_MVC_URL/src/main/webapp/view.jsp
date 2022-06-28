<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>view.jsp</title>
</head>
<body>
	<h2>view</h2>
	
	${requestScope.name} - ${requestScope.age} <br/>
	${param.id}
	
	
	
	${requestScope.id} <br/><!-- name을 id로 바꿔주니 1이 나옴  forward를 통해 키값을 통해 출력을 받고있음-->
	${requestScope.age}
	
	
	
</body>
</html>