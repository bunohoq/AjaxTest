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
	<!-- ex10.jsp -->
	<h1>Ajax <small>고양이 위치 관리</small></h1>
	
	<%-- ${dto} --%>
	
	<img src="/ajax/images/catty01.png" id="cat1">
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script
  src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>
	<script>
		//고양이 좌표 > 저장
		//- 다음번 방문 때도 그대로 유지
		//1. Cookie
		//2. Session > 탈락(∵다음번 방문)
		//3. DB
		
		$('#cat1').draggable({
			stop: function(event, ui) {
				//alert();
				//alert(ui.position.left);
				//alert(ui.position.top);
				
				//ajax 호출
				$.ajax({
					type: 'POST',
					url: '/ajax/ex10data.do',
					data: {
						id: 'cat1',
						x: ui.position.left,
						y: ui.position.top
					},
					error: function(a,b,c) {
						console.log(a,b,c);
					}
						
				});
				
			}
		});
		
		
		$('#${dto.id}')
			.css('left', ${dto.x})
			.css('top', ${dto.y});
		
	</script>
</body>
</html>












