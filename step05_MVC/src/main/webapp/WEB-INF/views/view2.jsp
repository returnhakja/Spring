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
	1. ��û ��ü�� ����� ���ο� ������ ��� : ${requestScope.msg} <br/>
	2. ��û ��ü�� ����� ���ο� ������ ��� : ${requestScope.customer} <br/>
	3. ${requestScope.customer.name } - ${requestScope.customer.age} 	<!-- ���� �������� ���� getXX�� �������� ���� -->
	

</body>
</html>