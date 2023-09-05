<%@page import="com.board.dto.Board"%>
<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
request.setCharacterEncoding("utf-8");
BoardDAO dao = BoardDAO.getInstance();
int num =Integer.parseInt(request.getParameter("num"));
Board board = dao.findByNum(num);

%>
</head>
<body>
<h3>글 수정하가</h3>
<form action="updateProc.jsp" method="post">
<input type="hidden" name="num" value="<%=num %>"  />
	<table border=1>
			<tr>
				<td>이름</td>
				<td><input type="text" name="writer" value="<%=board.getWriter()%>"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="<%=board.getSubject()%>"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="<%=board.getEmail()%>"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="content"><%=board.getContent() %></textarea> </td>
			</tr>	
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<td colspan="2"  align="center">
				<input type="submit" value="수정하기">
				<input type="reset" value="다시작성">
				</td>
			</tr>
  </table>
</form>
</body>
</html>