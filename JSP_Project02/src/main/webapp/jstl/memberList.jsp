<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 전체 보기</h3>
	<sql:setDataSource dataSource="jdbc/jsp" var="dataSource"
		scope="application" />
	<sql:query dataSource="${dataSource }" var="resultSet">
select * from memberdb
</sql:query>
	<table border="1">
		<tr>
			<c:forEach items="${resultSet.columnNames }" var="columnName">
				<th>${columnName }</th>
			</c:forEach>
		</tr>
		<c:forEach items="${resultSet.rowsByIndex }" var="row">
		<tr>
		<c:forEach items="${row }" var="col">
		<td>${col }</td>
		</c:forEach>
		</tr>
		</c:forEach>
	</table>
</body>
</html>