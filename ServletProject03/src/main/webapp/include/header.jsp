<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Header</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
		<!-- Brand/logo -->
<a class="navbar-brand" href="#">HOME</a>

<!-- Links -->
<ul class="navbar-nav mr-auto">
	<li class="nav-item"><a class="nav-link" href="/board/boardlist">Board</a></li>
	<li class="nav-item"><a class="nav-link" href="/product/plist">ProductList</a>
	</li>
	
	<c:if test="${sessionScope.suser.admin==1}">
	<li class="nav-item"><a class="nav-link" href="">회원목록</a>
	<li class="nav-item"><a class="nav-link" href="/product/pinsert">상품등록</a>
	</li>
	</c:if>
	
</ul>
<ul class="navbar-nav">
	<c:if test="${empty sessionScope.suser }">
		<li class="nav-item"><a class="nav-link" href="/member/login">로그인</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="/member/join">회원가입</a>
		</li>
	</c:if>


	<c:if test="${not empty sessionScope.suser}">
		<c:if test="${sessionScope.suser.admin == 1 }">
			<span class="navbar-text">${sessionScope.suser.name }(관리자)님
				반갑습니다.</span>
		</c:if>
		<c:if test="${sessionScope.suser.admin == 0 }">
			<span class="navbar-text">${sessionScope.suser.name }님
				반갑습니다.</span>
		</c:if>

		<li class="nav-item"><a class="nav-link" href="/member/logout">로그아웃</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="">회원변경</a></li>
	</c:if>
	</ul>
</nav>