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
		
		#item1 { background: tomato; }
		#item2 { background: gold; }
		#item3 { background: cornflowerblue; }
		#item4 { background: yellowgreen; }
		
		.item {
			margin: 10px;
			padding: 5px;
			text-align: right;
			padding-right: 15px;
			color: white;
			width: 150px;
			border-top-right-radius: 30px;
			border-bottom-right-radius: 30px;
		}
		.item > span {
			font-size: 12px;
			background: white;
			border-radius: 50%;
			padding: 5px;
			margin-left: 5px;
		}
		
		iframe {
			width: 100%;
			height: 500px;
			border: 1 solid black;

		
	</style>
</head>
<body>
	<!-- ex01.jsp -->
	<h1>설문 조사</h1>
	
	<table class="content">		
		<tr>
			<th></th>
		</tr>
		<tr>
			<th></th>
		</tr>
		<tr>
			<th></th>
		</tr>
		<tr>
			<th></th>
		</tr>
		<tr>
			<th></th>
		</tr>
	</table>
	<hr>
	<div>
		<div class="item" id="item1"></span></div>
		<div class="item" id="item2"></span></div>
		<div class="item" id="item3"></span></div>
		<div class="item" id="item4"></span></div>
	</div>
	
	<iframe src="/ajax/ex02data.do"></iframe>
	
	<!-- <h2> 다른 콘텐츠</h2>
	<div>
		<div><input type="text"></div>
		<div><input type="text"></div>
		<div><input type="text"></div>
	</div> -->
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
		
		/* setTimeout(() => {
			location.reload();
		}, 5000); */
	
	</script>
</body>
</html>

