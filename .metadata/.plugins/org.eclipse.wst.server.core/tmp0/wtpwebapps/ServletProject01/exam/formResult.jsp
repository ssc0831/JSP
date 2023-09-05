<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formResult</title>
</head>
<body>
<h3>formResult.jsp</h3>
이름 : ${form.name }<br/> 
<!-- <c:out value="${form.name }"></c:out> -->
나이 : ${form.age }<br/>
성별 : ${form.gender }<br/>
취미 : <c:forEach items="${form.hobby }" var="h">${h } </c:forEach><br/>
직업 : ${form.job }<br/>
</body>
</html>