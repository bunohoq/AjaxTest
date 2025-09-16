package com.test.java;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.java.model.AjaxDAO;
import com.test.java.model.CatDTO;

@WebServlet(value = "/ex10data.do")
public class Ex10Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex10Data.java
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String x = req.getParameter("x");
		String y = req.getParameter("y");
		
		AjaxDAO dao = new AjaxDAO();
		
		CatDTO dto = new CatDTO();
		dto.setId(id);
		dto.setX(x);
		dto.setY(y);
		
		dao.editCat(dto);
		
	}

}














