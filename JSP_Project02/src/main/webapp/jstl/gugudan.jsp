<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>구구단</h3>
<c:forEach begin="1" end="9" var="dan">
${dan}단<br/>
	<c:forEach begin="1" end="9" var="k">
${dan}*${k}=${dan*k}<br/>

	</c:forEach>
	<br/>
</c:forEach>	
<hr/>
	<%
	for (int i = 1; i < 10; i++) {
	%>
	<br/>
	<%=i%>단
	<br/>

	<%
	for (int j = 1; j < 10; j++) {
	%>
	<%=i%>*<%=j%> = <%=i*j%><br/>
<%
	}
}
%>
<br/><br/><br/>

</body>
</html>