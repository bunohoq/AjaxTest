package com.test.java;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.java.model.AjaxDAO;
import com.test.java.model.SurveyDTO;

@WebServlet(value = "/ex02.do")
public class Ex02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Ex02.java(ex02.jsp)
		//1. DB 접속 > 데이터 가져오기
		//2. 화면에 출력하기
		
		//Ex02.java(ex02.jsp)
		//2. 화면에 출력하기
		
		//Ex02Data.java(ex02data.jsp)
		//1. DB 접속 > 데이터 가져오기
		

		//Ex02.java
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex02.jsp");
		dispatcher.forward(req, resp);
	}

}
