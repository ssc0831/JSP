<%@page import="com.member.dao.MemberDAO"%>
<%@page import="com.member.dao.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
//String sid = (String)session.getAttribute("sUserid");
%>

<jsp:useBean id="member" class="com.member.dto.Member"/>
<jsp:setProperty property="*" name="member"/>

<%
/*member.setUserid(sid)*/;
MemberDAO dao = MemberDAOImpl.getInstance();
dao.memberUpdate(member);
session.invalidate();
response.sendRedirect("loginForm.jsp");
%>
