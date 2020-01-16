package com.ryon.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/mb_ok")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		PrintWriter out = response.getWriter();
		int result = DbClass.insert(id, pw, name, email, phone, address, birthday);
		if(result == 0) {
			//에러페이지
			//response.sendRedirect("member.jsp");
			out.print("<script>alert('오류입니다');history.back();</script>");
			
		}else {
			response.sendRedirect("mb_ok.jsp");
		}
		
		
		response.setContentType("text/html;charset=utf-8");
		
		
		DbClass a = new DbClass();
		a.insert(id, pw, name, email, phone, address, birthday);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
}
