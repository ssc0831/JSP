<%@page import="com.member.dao.MemberDAOImpl"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
String userid = request.getParameter("userid");
String pwd = request.getParameter("pwd");
MemberDAO dao = MemberDAOImpl.getInstance();
int flag = dao.loginCheck(userid, pwd);
if(flag==0 || flag==1){
	session.setAttribute("sUserid", userid);
}
out.println(flag);
%>
