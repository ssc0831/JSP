<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP3</title>
</head>

<script>
function check(){
	if (document.getElementById("name").value=="") {
		alert("이름을 입력하세요.");
		return false;
	}
	if (document.getElementById("kor").value==""||isNaN(document.getElementById("kor").value)) {
		alert("국어 성적을 입력하세요.");
		document.getElementById("kor").value==""
		return false;
	}
	if (document.getElementById("eng").value==""||isNaN(document.getElementById("eng").value)) {
		alert("영어 성적을 입력하세요.");
		document.getElementById("eng").value==""
		return false;
	}
	if (document.getElementById("math").value==""||isNaN(document.getElementById("math").value)) {
		alert("수학 성적을 입력하세요.");
		document.getElementById("math").value==""
		return false;
	}
		return true;
}
</script>
<body>
	<form action="scoreResult.jsp" method="get" id=frm onsubmit="return check()">
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
		<!-- <input type="submit" value="전송" onclick="check()"> -->
		<button type="button" onclick="check()">button 태그 전송</button>
		</p>
	</form>
</body>
</html>