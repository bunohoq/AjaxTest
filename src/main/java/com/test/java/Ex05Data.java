package com.test.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.java.model.AjaxDAO;

@WebServlet(value = "/ex05data.do")
public class Ex05Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex05Data.java
		
		String txt1 = req.getParameter("txt1");
		
		AjaxDAO dao = new AjaxDAO();
		String name = dao.getInsa(txt1);
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(name);
	}

}