package com.test.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.java.model.AjaxDAO;

@WebServlet(value = "/ex06data.do")
public class Ex06Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex06Data.java
		//1. 데이터 가져오기(id)
		//2. DB 작업 > select
		//3. 결과 반환
		
		String id = req.getParameter("id");
		
		AjaxDAO dao = new AjaxDAO();
		
		int result = dao.checkId(id); //사용가능(O)
		
		resp.getWriter().print(result);
		resp.getWriter().close();
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex06data.jsp");
		dispatcher.forward(req, resp);
	}

}