<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${param.id}가 좋아하는 색깔은 ${param.color}입니다.
<hr/>
<c:choose>
<c:when test="${param.color=='yellow'}">
<c:set var="c" value="노랑색"/>
</c:when>

<c:when test="${param.color=='blue'}">
<c:set var="c" value="파랑색"/>
</c:when>

<c:when test="${param.color=='orange'}">
<c:set var="c" value="오렌지색"/>
</c:when>

<c:when test="${param.color=='pink'}">
<c:set var="c" value="분홍색"/>
</c:when>

<c:when test="${param.color=='black'}">
<c:set var="c" value="검정색"/>
</c:when>
</c:choose>

<c:if test="${param.id == null || param.id == '' }" >
<c:set var="name" value="GUEST">
</c:set>
</c:if>
${name}이 좋아하는 색깔은 ${c}입니다.<br/>
</body>
</html>