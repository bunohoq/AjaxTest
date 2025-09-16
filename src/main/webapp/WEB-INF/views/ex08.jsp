<%@page language="java" contentType="text/html; charset=UTF-8"
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
	<!-- ex08.jsp -->
	<h1>Ajax <small>전송 데이터(수신 데이터)의 형식</small></h1>
	
	<h2>수신(응답) 데이터</h2>
	
	<h3>Text <small>ajax.responseText</small></h3>
	<div>
		<input type="button" value="확인" id="btn1">
		<div class="message" id="div1"></div>
	</div>
	
	<h3>Text <small>ajax.responseText</small></h3>
	<div>
		<input type="button" value="확인" id="btn2">
		<div class="message" id="div2"></div>
	</div>
	
	<hr>
	
	<h3>XML <small>ajax.responseXML</small></h3>
	<div>
		<input type="button" value="확인" id="btn3">
		<div class="message" id="div3"></div>
	</div>
	
	<h3>XML <small>ajax.responseXML</small></h3>
	<div>
		<input type="button" value="확인" id="btn4">
		<div class="message" id="div4"></div>
	</div>
	
	<hr>
	
	<h3>JSON <small>ajax.responseText</small></h3>
	<div>
		<input type="button" value="확인" id="btn5">
		<div class="message" id="div5"></div>
	</div>
	
	<h3>JSON  <small>ajax.responseText</small></h3>
	<div>
		<input type="button" value="확인" id="btn6">
		<div class="message" id="div6"></div>
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
	
		/*
			$.ajax({
				type: 'GET',				//메서드 방식
				url: '/ex01.do',			//서버측 URL
				async: true,				//동기(false), 비동기(true)
				data: 'key=value&key=value',//전송할 데이터
				dataType: 'text',			//수신할 데이터 형식(text,xml,json)
				success: function(result) {
					//result(수신 데이터)
				},
				error: function(a,b,c) {
					//예외 처리
				}
			})
		*/
	
		$('#btn1').click(() => {
			
			//서버로부터 > 텍스트 반환 + 단일값
			$.ajax({
				type: 'GET',
				url: '/ajax/ex08data.do',
				
				//예제 구분용
				data: 'm=1', 
				
				//돌려받는 데이터의 형식 > result 형식
				dataType: 'text',
				success: function(result) {
					$('#div1').text(result);
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		});
		
		$('#btn2').click(() => {
			
			//서버로부터 > 텍스트 반환 + 다중값(CSV)
			$.ajax({
				type: 'GET',
				url: '/ajax/ex08data.do',
				data: 'm=2',
				dataType: 'text',
				success: function(result) {
					/*
						hong,1111,홍길동,1
						dog,1111,강아지,1
						cat,1111,고양이,2
					*/
					//alert(result);
					
					const users = result.trim().split('\r\n');
					
					users.forEach(user => {
						//hong,1111,홍길동,1
						const prop = user.split(',');
						
						$('#div2').append(`
							<ul>
								<li>아이디: \${prop[0]}</li>
								<li>암호: \${prop[1]}</li>
								<li>이름: \${prop[2]}</li>
								<li>등급: \${prop[3]}</li>
							</ul>
						`);
						
					});
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		});
		
		$('#btn3').click(() => {
			
			//서버로부터 > XML + 단일값
			$.ajax({
				type: 'GET',
				url: '/ajax/ex08data.do',
				data: 'm=3',
				dataType: 'xml',
				success: function(result) {
					
					//[object XMLDocument]
					//alert(result);
					
					/*
					 	Well-formed XML
					 	
					 	<?xml version="1.0" encoding="UTF-8"?>
					 	<question id="q1">질문입니다.</question>
					 	
					*/
					
					//JavaScript XML DOM
					//alert(result.documentElement.textContent);
					
					//alert($(result).find('question').text());
					//alert($(result).find('#q1').text());
					
					$('#div3').text($(result).find('#q1').text());
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		});
		
		$('#btn4').click(() => {
			
			$.ajax({
				type: 'GET',
				url: '/ajax/ex08data.do',
				data: 'm=4',
				dataType: 'xml', //돌려받을 데이터의 형식
				success: function(result) {
					
					$(result).find('user').each((index, user) => {
						
					let temp = '';
					temp += '<ul>';
					temp += '<li>아이디: ' + $(user).find('id').text() + '</li>';
					temp += '<li>암호: ' + $(user).find('pw').text() + '</li>';
					temp += '<li>이름: ' + $(user).find('name').text() + '</li>';
					temp += '<li>등급: ' + $(user).find('grade').text() + '</li>';
					temp += '<ul>';
					
					$('#div4').append(temp);
					
					});
					
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
				
			});
			
		});
		
		$('#btn5').click(() => {
			
			//JSON + 단일값
			$.ajax({
				type: 'GET',
				url: '/ajax/ex08data.do',
				data: 'm=5',
				dataType: 'json',
				success: function(result) {
					
					//ajax에서 응답 데이터로 JSON을 사용하는 이유!!
					//- CSV > 파싱(split) 필요
					//- XML > 파싱(XMLDocument) 필요
					//- JSON > 파싱 불필요 > JSON을 그냥 자바스크립트 객체(배열)로 처음부터 인식 
					//console.log(result);
					
					//alert(result.question);
					
					$('#div5').text(result.question);
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		});
		
		$('#btn6').click(() => {
			
			//JSON + 다중값
			$.ajax({
				type: 'GET',
				url: '/ajax/ex08data.do',
				data: 'm=6',
				dataType: 'json',
				success: function(result) {
					
					//alert(result);
					$(result).each((index, user) => {
						
						let temp = '';
						temp += '<ul>';
						temp += '<li>아이디: ' + user.id + '</li>';
						temp += '<li>암호: ' + user.pw + '</li>';
						temp += '<li>이름: ' + user.name + '</li>';
						temp += '<li>등급: ' + user.grade + '</li>';
						temp += '<ul>';
						
						$('#div6').append(temp);
						
					});
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		});
		
		
	
	</script>
</body>
</html>

















