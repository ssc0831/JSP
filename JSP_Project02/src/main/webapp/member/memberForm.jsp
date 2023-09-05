<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- <script src="/JSP_Project02/js/member.js"></script> -->
<script src="../js/member.js"></script>
<title>Member Form</title>
</head>
<body>

<div class="container mt-5">
  <h2>회원가입</h2>
  <form action="memberInsertPro.jsp" id="frm" method="post">
  <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Your Name" name="name">
    </div>
  
   <div class="row">
   <div class="col">
      <label for="userid">UserID:</label>
      <input type="text" class="form-control" id="userid" placeholder="Enter Your UserID" name="userid" readonly="readonly">
    </div>
     <div class="col align-self-end">
    <button type="button" class="btn btn-primary" id="idCheckBtn">중복확인</button>
    </div>
 </div>

    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter Your password" name="pwd">
    </div>
    
    <div class="form-group">
      <label for="pwd_check">Password_check:</label>
      <input type="password" class="form-control" id="pwd_check" placeholder="Enter password_check" name="pwd_check">
    </div>
    
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter Your email" name="email">
    </div>
  
    <div class="form-group">
      <label for="phone">Phone:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter Your Phone" name="phone">
    </div>
   
    <div class="form-group form-check-inline">
      <label class="form-check-label">
        <input class="form-check-input" type="radio" name="admin" value="0" checked> 일반회원
      </label>
    </div>
   
    <div class="form-group form-check-inline">
      <label class="form-check-label">
        <input class="form-check-input" type="radio" name="admin" value="1"> 관리자
      </label>
    </div>
    
    <button type="submit" class="btn btn-primary" id="sendBtn">Submit</button>
  </form>
</div>

</body>
</html>