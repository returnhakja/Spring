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
	
	
	
	${requestScope.id} <br/><!-- name�� id�� �ٲ��ִ� 1�� ����  forward�� ���� Ű���� ���� ����� �ް�����-->
	${requestScope.age}
	
	
	
</body>
</html>