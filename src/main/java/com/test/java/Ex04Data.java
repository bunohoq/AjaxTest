package com.test.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.java.model.AjaxDAO;
import com.test.java.model.SurveyDTO;

@WebServlet(value = "/ex04data.do")
public class Ex04Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex04Data.java
		
		
		
		//GET + 보내기
		//String txt1 = req.getParameter("txt1");
		//System.out.println("txt1: " + txt1);
		
		
		
		//GET + 받아오기
//		AjaxDAO dao = new AjaxDAO();
//		SurveyDTO dto = dao.getSurvey(1);
//		String question = dto.getQuestion();
//		
//		resp.setCharacterEncoding("UTF-8");
//		PrintWriter writer = resp.getWriter();
//		writer.print(question);
//		writer.close();
		
		
		//GET + 보내기 + 받아오기
		String num3 = req.getParameter("num3"); //직원 번호
		
		AjaxDAO dao = new AjaxDAO();
		String name = dao.getInsa(num3);
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(name);
		resp.getWriter().close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//System.out.println("POST 요청");
		
		//POST + 보내기
		//req.setCharacterEncoding("UTF-8");
		//String txt4 = req.getParameter("txt4");
		//System.out.println("txt4: " + txt4);

		
		
		//POST + 받아오기
//		AjaxDAO dao = new AjaxDAO();
//		SurveyDTO dto = dao.getSurvey(1);
//		String question = dto.getQuestion();
//		
//		System.out.println(question);
//		
//		resp.setCharacterEncoding("UTF-8");
//		PrintWriter writer = resp.getWriter();
//		writer.print(question);
//		writer.close();
		
		
		//POST + 보내기 + 받아오기
		String num6 = req.getParameter("num6"); //직원 번호
		
		AjaxDAO dao = new AjaxDAO();
		String name = dao.getInsa(num6);
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(name);
		resp.getWriter().close();
		
		
	}

}












