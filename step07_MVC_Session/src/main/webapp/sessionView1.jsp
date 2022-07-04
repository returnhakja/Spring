<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionView1</title>
</head>
<body>
	<h2>sessionView1.page</h2>
	<div>id : ${sessionScope.id}</div>
	<div>age : ${sessionScope.age}</div>
	<div>job : ${sessionScope.job}</div>
	
	<hr>
	<h3>session 삭제요청</h3>
	<a href="session/jobDelete.do">job 삭제</a> <br/>
	<a href="session/sessionDelete.do">id, age 삭제</a> <br/>
	<a href="index.jsp">index.jsp로 돌아가기</a>

</body>
</html>