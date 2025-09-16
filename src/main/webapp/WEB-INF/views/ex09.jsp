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
		h1 {
			display: flex;
			justify-content: space-between;
		}
		h1 > span {
			font-size: 20px;
			cursor: poiter;
		}
	</style>
</head>
<body>
	<!-- ex09.jsp -->
	<!-- 
		
		주소록(읽기, 쓰기)
		- Ajax 처리
	
	 -->
	 <h1>주소록 <span data-sidebar-button="sidebar">🌺</span></h1>
	 
	 <table id="list">
	 	<thead>
	 		<tr>
	 			<th>번호</th>
	 			<th>이름</th>
	 			<th>나이</th>
	 			<th>성별</th>
	 			<th>전화</th>
	 			<th>주소</th>
	 		</tr>
	 	</thead>
	 	<tbody>
	 		<tr>
	 			<td>1</td>
	 			<td>홍길동</td>
	 			<td>20</td>
	 			<td>남자</td>
	 			<td>010-1234-5667</td>
	 			<td>서울시 강남구 역삼동</td>
	 		</tr>
	 	</tbody>
	 </table>
	 
	 <div data-sidebar-window="sidebar"
	 	  data-sidebar-title="주소록 추가하기"
	 	  data-sidebar-direction="right">
	 	
	 	<form id="form1">
	 		<div>
	 			<label>이름: </label>
	 			<input type="text" name="name" id="name">
	 		</div>
	 		<div>
	 			<label>나이: </label>
	 			<input type="text" name="age" id="age">
	 		</div>
	 		<div>
	 			<label>성별:</label>
	 			<select name="gender" id="gender">
	 				<option value="m">남자</option>
	 				<option value="f">여자</option>
	 			</select>
	 		</div>	 	
	 		<div>
	 			<label>전화: </label>
	 			<input type="text" name="tel" id="tel">
	 		</div>
	 		<div>
	 			<label>주소: </label>
	 			<input type="text" name="address" id="address">
	 		</div>
	 		<div>
	 			<input type="button" value="추가하기" id="btn1">
	 		</div>
	 	</form>
	 	
	 </div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
		//페이지 로딩 > 주소록 목록 출력 
		function list() {
			
			$.ajax({
				type: 'GET',
				url: '/ajax/ex09data.do',
				dataType: 'json',
				success: function(result) {
					
					$('#list tbody').html('');
					
					result.forEach(item => {
						$('#list tbody').append(`
								
							<tr>		
								<td>\${item.seq}</td>
								<td>\${item.name}</td>
								<td>\${item.age}</td>
								<td>\${item.gender}</td>
								<td>\${item.tel}</td>
								<td class="left">\${item.address}</td>
							</tr>		
								
						`);
					});
				},
				error: function(a,b,c) {
					console.log(a,b,c)
				}
			});
		}
		list();
		
		/*
			
			ajax 데이터 전송 형식
			1. Query String
				- data: 'name=홍길동&age=20&gender=m'
				
			2. 직렬화(serialize)
				- 객체를 한줄의 문자열로 만드는 작업
				
			3. 객체 직접 대입
				
		
		*/
		$('#btn1').click(() => {

			//alert($('#form1').serialize());
			
			//주소록 추가하기
			$.ajax({
				type: 'POST',
				url: '/ajax/ex09data.do',
				//1.
				//data: 'name=' + $('#name').val() + '&age=' + $('#age').val() + '&gender=' + $('#gender').val() + '&tel=' + $('#tel').val() + '&address=' + $('#address').val() , 
				
				//2.
				//data: $('#form1').serialize();
				
				//3. 
				data: {
					name: $('#name').val(),
					age: $('#age').val(),
					gender: $('#gender').val(),
					tel: $('#tel').val(),
					address: $('#address').val()
				},
				dataType: 'json',
				success: function(result) {

					//alert(result.result);
					if (result.result > 0) {

						//고민?
						//- 새로운 항목 + 기존 항목 > 다시 가져오기
						//list();
						
						//- 새로운 항목 > 동적으로 <tr> 생성
						$('#list tbody').prepend(`							<tr>		
								<td>\${$(result.seq)}</td>
								<td>\${$('#name')}</td>
								<td>\${$('#age')}</td>
								<td>\${$('#gender')}</td>
								<td>\${$('#tel')}</td>
								<td class="left">\${$('#address')}</td>
							</tr>
							
						`);
						
						
						
						
						$('#name').val('');
						$('#age').val('');
						$('#gender').val('');
						$('#tel').val('');
						$('#address').val('');
						
						$('body > div > div > span.material-symbols-outlined').click();
		
					} else {
						alert('failde')
					}

				},
				error: function(a,b,c) {
					console.log(a,b,c)
				}
				
			});
			
		});
	
	
	</script>
</body>
</html>

