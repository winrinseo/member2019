package com.ryon.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

/**
 * Servlet implementation class login_chk
 */
@WebServlet("/login_chk")
public class login_chk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_chk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		
		PrintWriter out = response.getWriter();
		//int result = DbClass.insert(uid, upw);
		
		HttpSession session = request.getSession();
		
		
		response.setContentType("text/html;charset=utf-8");
		//out.println(uid);
		//out.println(upw);
		//int result = lcheck.select(uid,upw);
		
		
		
		//lcheck a = new lcheck();
		//a.select(uid, upw);
		int result = lcheck.select(uid, upw);//lcheck에서 반환된 result값이 들어간다.
		if(result == 0) {
			//에러페이지
			//response.sendRedirect("member.jsp");
			out.print("<script>alert('아이디 혹은 비밀번호가 틀렸습니다.');history.back();</script>");
			
			
		}else {
			out.print("<script>alert('로그인성공');location.replace(index.jsp);</script>");
			session.setAttribute("name", uid);
			response.sendRedirect("main.jsp");
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
