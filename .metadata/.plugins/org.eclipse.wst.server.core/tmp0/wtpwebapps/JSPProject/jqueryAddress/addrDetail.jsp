<%@page import="com.jqueryAddress.JAddressDAOImpl"%>
<%@page import="com.jqueryAddress.JAddressDAO"%>
<%@page import="com.jqueryAddress.AddressVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>

<%
int num = Integer.parseInt(request.getParameter("num"));
JAddressDAO dao = JAddressDAOImpl.getInstance();
AddressVO avo = dao.findByNum(num);
%>

<script>
function del() {
	if (confirm("삭제하시겠습니까?")) {
		location.href="deleteProcess.jsp?num=<%=num %>";
	}
}

function zipfinder() {
	window.open("zipCheck.jsp", "", "width=700 height=400")
}
</script>

<body>
<h3>상세보기</h3>
<form action="updateProcess.jsp" method="post">
<input type="hidden" name="num" value="<%=num%>">
<table>
<tr>
<th>번호</th>
<td>
<input type="text" name="num" value="<%=avo.getNum()%>" readonly="readonly">
</td>
</tr>
<tr>
<th></th>
<td>
<input type="text" name="name" value="<%=avo.getName()%>"> </td>
</tr>
<tr>
<th>우편번호</th>
<td>
<input type="text" name="zipcode" id="zipcode" value="<%=avo.getZipcode()%>" size="7">
<input type="button" value="검색" onclick="zipfinder()">
</td>
<tr>
<th>전화번호</th>
<td>
<input type="text" name="tel" value="<%=avo.getTel() %>">
</td>
</tr>

<tr>
<td colspan="2">
<input type="submit" value="수정">
<input type="reset" value="수정취소">
<input type="button" value="삭제" onclick="del()">
<input type="text" value="전체보기" onclick="location.href='list.jsp'">
</td>
</tr>


</table>
</form>

</body>
</html>