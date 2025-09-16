<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<style>
		
	</style>
</head>
<body>
	<!-- ex06.jsp -->
	<h1>아이디 중복 검사</h1>
	
	<form method="POST" action="/ajax/ex06ok.do">
	<table class="vertical">
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" id="name" class="short"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>
			<input type="text" name="id" id="id" class="short">
			<input type="button" value="중복검사" id="btnCheck">
			<span id="result"></span>
			</td>
		</tr>
		<tr>
			<th>암호</th>
			<td><input type="password" name="pw" id="pw" class="short"></td>
		</tr>
	</table>
	<div>
		<input type="submit" value="가입하기" id="btnRegister">
	</div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	
		$('#btnCheck').click(() => {
			//입력한 아이디 > 전송 > 결과 반환
			if ($('#id').val().trim() == '') {
				alert('아이디를 입력하세요.');
				return;
			
			}
			$.ajax({
				type: 'GET',
				url: '/ajax/ex06data.do',
				data: 'id=' + $('#id').val(),
				success: function(result) {
					//alert(result)
					
					if (result == 0) {
						$('#result').text('사용 가능한 아이디입니다.');
						complete = 1;
					} else {
						$('#result').text('이미 사용중인 아이디입니다.');
						complete = 1;
					}
					
					

				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
			let complete = 0;		//전송가능(1), 전송불가능(0)
			
			$('form').submit((evt) => {
				
				if (complete == 0) {

					alert('아이디 중복 검사를 진행하세요.')

					evt.preventDefault();
					return false;
					
				} else if (complete == 2) {

					alert('아이디를 변경후에 반드시 중복검사를 진행하세요.')
					
					evt.preventDefault();
					return false;
				}
			});
			
			//입력값이 변경되면 발생
			$('#id').change(() => {
				//alert();
				complete = 2;
			})
		
		});
	</script>
</body>
</html>

