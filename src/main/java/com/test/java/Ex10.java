package com.test.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.java.model.AjaxDAO;
import com.test.java.model.CatDTO;

@WebServlet(value = "/ex10.do")
public class Ex10 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex10.java
		AjaxDAO dao = new AjaxDAO();
		
		CatDTO dto = dao.getCat("cat1");
		
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex10.jsp");
		dispatcher.forward(req, resp);
	}

}

















