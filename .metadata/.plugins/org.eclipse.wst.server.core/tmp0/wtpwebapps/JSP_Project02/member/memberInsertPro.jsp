<%@page import="com.member.dao.MemberDAOImpl"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@page import="com.member.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="member" class="com.member.dto.Member"/>
<jsp:setProperty property="*" name="member"/>

<% 
MemberDAO dao = MemberDAOImpl.getInstance();
dao.memberInsert(member);
response.sendRedirect("memberList.jsp");
%>


