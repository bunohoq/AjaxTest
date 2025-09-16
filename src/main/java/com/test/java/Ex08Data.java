package com.test.java;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.java.model.AjaxDAO;
import com.test.java.model.UserDTO;

@WebServlet(value = "/ex08data.do")
public class Ex08Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex08Data.java
		String m = req.getParameter("m");
		
		if (m.equals("1")) {
			m1(req, resp);
		} else if (m.equals("2")) {
			m2(req, resp);
		} else if (m.equals("3")) {
			m3(req, resp);
		} else if (m.equals("4")) {
			m4(req, resp);
		} else if (m.equals("5")) {
			m5(req, resp);
		} else if (m.equals("6")) {
			m6(req, resp);
		}

	}

	private void m6(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//서버가 > JSON 반환 + 다중값 > m2() 동일
		AjaxDAO dao = new AjaxDAO();
		
		List<UserDTO> list = dao.getUsers();
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		/*
		
			[
				{
					"id": "hong",
					"pw": "1111",
					"name": "홍길동",
					"grade": 1
				},
				{
					"id": "hong",
					"pw": "1111",
					"name": "홍길동",
					"grade": 1
				}
			]
		
		*/
		
		String temp = "";
		
		temp += "[";
		
		for (UserDTO dto : list) {
			
			temp += """
			
				{
					"id": "%s",
					"pw": "%s",
					"name": "%s",
					"grade": %s
				},""".formatted(dto.getId()
						, dto.getPw()
						, dto.getName()
						, dto.getGrade());
			
		}
		
		temp = temp.substring(0, temp.length() - 2);
		
		temp += "]";
		
		PrintWriter writer = resp.getWriter();
		writer.print(temp);
		writer.close();	
		
	}

	private void m5(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//서버가 > JSON 반환 + 단일값 > m1() 동일
		AjaxDAO dao = new AjaxDAO();
		String question = dao.getSurvey(1).getQuestion();
		
		/*
			
			{
				"question": "질문입니다."
			}
		
		*/
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.printf("""
		
			{
				"question": "%s"
			}
						
		""", question);
		writer.close();		
		
	}

	private void m4(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//서버가 > XML 반환 + 다중값 > m2() 동일
		AjaxDAO dao = new AjaxDAO();
		
		List<UserDTO> list = dao.getUsers();
		
		//list > XML
		resp.setContentType("text/xml");
		resp.setCharacterEncoding("UTF-8");
		
		String temp = "";
		temp += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		
		/*
			<list>
				<user>
					<id></id>
					<pw></pw>
					<name></name>
					<grade></grade>
				</user>
				<user>
					<id></id>
					<pw></pw>
					<name></name>
					<grade></grade>
				</user>
			</list>
		*/
		
		temp += "<list>";
		
		for (UserDTO dto : list) {
			temp += "<user>";
				temp += "<id>" + dto.getId() + "</id>";
				temp += "<pw>" + dto.getPw() + "</pw>";
				temp += "<name>" + dto.getName() + "</name>";
				temp += "<grade>" + dto.getGrade() + "</grade>";
			temp += "</user>";
		}
		
		temp += "</list>";
		
		PrintWriter writer = resp.getWriter();
		writer.print(temp);
		writer.close();	
		
	}

	private void m3(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//서버가 > XML 반환 + 단일값
		AjaxDAO dao = new AjaxDAO();
		String question = dao.getSurvey(1).getQuestion();
				
		resp.setContentType("text/xml");
		resp.setCharacterEncoding("UTF-8");
		
		/*
		 	Well-formed XML
		 	
		 	<?xml version="1.0" encoding="UTF-8"?>
		 	<question id="q1">질문입니다.</question>
		 	
		*/
		
		PrintWriter writer = resp.getWriter();
		writer.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		writer.printf("<question id=\"q1\">%s</question>", question);
		writer.close();		
		
		
	}

	private void m2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//서버가 > 텍스트 반환 + 다중값
		AjaxDAO dao = new AjaxDAO();
		
		List<UserDTO> list = dao.getUsers();
		
		//list > 문자열
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		String temp = "";
		
		for (UserDTO dto : list) {
			temp += String.format("%s,%s,%s,%s\r\n"
									, dto.getId()
									, dto.getPw()
									, dto.getName()
									, dto.getGrade());
		}
		
		PrintWriter writer = resp.getWriter();
		writer.print(temp);
		writer.close();	
		
	}

	private void m1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//서버가 > 텍스트 반환 + 단일값
		
		AjaxDAO dao = new AjaxDAO();
		String question = dao.getSurvey(1).getQuestion();
		
		//서버가 클라이언트(브라우저, ajax)에게 돌려주는 데이터의 형식 지정
		//- 응답 헤더 설정(Response Header)
		resp.setContentType("text/plain"); //MIME > 문자열
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.print(question); //토큰(Token)
		//writer.print("<h1>데이터</h1>");
		writer.close();		
		
	}

}











