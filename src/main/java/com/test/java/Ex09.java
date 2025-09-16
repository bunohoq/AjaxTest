package com.test.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/ex09.do")
public class Ex09 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex09.java
		
		//이전 구현 > SSR > PC 화면
		//1. 서블릿 호출(ex09.do)
		//2. DB 작업 > 목록
		//3. 목록 > JSP 전달 > 출력
		
		//이번 구현 >CSR(+ajax) > 모바일 화면
		//1. 서블릿(ex09.do) > 아무것도 안함
		//2. JSP 페이지 > ajax 사용 > 서버에게 목록 요청
		//3. 서블릿(ex09data.do) 응답 > DB 작업 > 목록 > ajax에게 반환
		//4. 반환받은 목록을 JSP가 화면에 출력(자바스크립트를 사용해서)
		
		//CSR
		//- Vue, React, Angular + 서버쪽 데이터(ajax)
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex09.jsp");
		dispatcher.forward(req, resp);
	}

}
