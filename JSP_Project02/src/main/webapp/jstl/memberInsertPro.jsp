<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%
request.setCharacterEncoding("utf-8");
String userid = request.getParameter("userid");
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
String admin = request.getParameter("admin");
%>

<!-- insert into memberdb values(?,?,?,?,?,?)  -->
<sql:setDataSource dataSource="jdbc/jsp" var="dataSource" scope="application" />
<sql:update dataSource="${dataSource }">
insert into memberdb(name, userid, pwd, email, phone, admin) values(?,?,?,?,?,?)
<sql:param value="${param.name }"/>
<sql:param value="<%=userid %>"/>
<sql:param value="<%=pwd %>"/>
<sql:param value="<%=email %>"/>
<sql:param value="<%=phone %>"/>
<sql:param value="<%=admin %>"/>
</sql:update>

<c:import url="memberList.jsp" />