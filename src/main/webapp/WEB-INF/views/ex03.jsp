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
	<!-- ex03.jsp -->
	<h1>Ajax</h1>
	
	<!-- 버튼 클릭 > 서버의 데이터를 가져와서 화면에 출력하기 -->
	<div>
		<input type="button" value="데이터 가져오기" id="btn1">
		<hr>
		<pre class="message"></pre>
	</div>
	<hr>
	<div>
		다른 콘텐츠: <input type="text">
	</div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
	
		/* 
		$('#btn1').click(() => {
			location.href = '/ajax/ex03data.do';
		}); 
		*/
		
		<c:if test="${not empty id}">
		$('.message').text('${id}');
		</c:if>
		
		$('#btn1').click(() => {
			
			/*
			
				비동기 자바스크립트 통신
				1. 순수 자바스크립트 > XMLHttpRequest 사용
				2. 각종 라이브러리
					- jQuery
					- 기타 라이브러리
				3. 순수 자바스크립트 > fetch API(ES6)
				
			*/
			
			//ajax 객체 역할
			//- 눈에 안보이는 객체
			//- 눈에 안보이는 무전기(전화기) ***
			//- 브라우저와는 별도로 서버와 통신을 할 수 있다.
			//- *** ajax 객체 HTML, CSS, JavaScript 실행 능력이 없다.
			
			//1. ajax 객체 생성
			const ajax = new XMLHttpRequest();
				
			console.log(ajax.readyState); //0
			
			//2. 이벤트 매핑
			//readyState
			//0: ajax 객체 생성 직후 > 초기화하기 전
			//1: open() 호출 > ajax 초기화
			//2: send() 호출 직후 > 서버는 아직 요청 받기 전
			//3: 돌려받는 데이터의 일부 수신
			//4: 모든 데이터를 돌려받음
			ajax.onreadystatechange = function() {
				//0 > 1 > 2 > 3 > 4
				//console.log(ajax.readyState);
				
				//http 상태코드 > 검색
				
				if (ajax.readyState == 4) {
					
				//돌려받은 데이터에 접근
				$('.message').append('<div>' + ajax.responseText + '</div>');
				$('.message').append('<div>' + ajax.status + '</div><hr>');
					
					
				} else if (ajax.readyState == 4 && ajax.status != 200) {
					$('.message').append('<div>오류발생</div>');
				}
				
			};
			
			//3. 연결 설정(아무일도 발생 안함)
			//<form method="POST" action="/ajax/ex03data.do">
			ajax.open('GET', '/ajax/ex03data.do');
			
			//4. 연결 시도(서버에게 요청)
			//- submit 버튼 역할
			ajax.send();
			
		}); 
		
	</script>
</body>
</html>












