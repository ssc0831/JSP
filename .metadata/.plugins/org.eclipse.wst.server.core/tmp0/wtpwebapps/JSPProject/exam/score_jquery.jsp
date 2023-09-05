<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP3</title>
</head>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script>
$(document).ready(function(){
	$("#btn").click(function(){
	if($("#name").val()==""){
		alert("이름을 입력하세요.")
		return;
		}
	//if($("#kor").val()==""||isNaN($("#kor").val())){
	if($("#kor").val()==""||!$.isNumeric($("#kor").val())){
		alert("숫자로 국어 성적을 입력하세요.")
		$("#kor").val("");
		return;
		}
	if($("#eng").val()==""||!$.isNumeric($("#eng").val())){
		alert("숫자로 영어 성적을 입력하세요.")
		$("#eng").val("");
		return;
		}
	if($("#math").val()==""||!$.isNumeric($("#math").val())){
		alert("숫자로 수학 성적을 입력하세요.")
		$("#math").val("");
		return;
		}
	
	$("#frm").submit();
	})
})
</script>
<body>
	<form action="scoreResult2.jsp" method="post" id=frm>
		<p>
			이름 : <input type="text" name="name" id="name">
		</p>
		<p>
			국어 : <input type="text" name="kor" id="kor">
		</p>
		<p>
			영어 : <input type="text" name="eng" id="eng">
		</p>
		<p>
			수학 : <input type="text" name="math" id="math">
		</p>
		<p>
		<input type="button" value="전송" id="btn">
		</p>
	</form>
</body>
</html>