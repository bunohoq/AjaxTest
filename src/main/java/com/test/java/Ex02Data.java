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

@WebServlet(value = "/ex02data.do")
public class Ex02Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex02Data.java
		AjaxDAO dao = new AjaxDAO();
		SurveyDTO dto = dao.getSurvey(1);
		
		req.setAttribute("dto", dto);

	}

}




