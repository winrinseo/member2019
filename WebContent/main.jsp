<%@page import="com.ryon.servlet.lcheck"%>
<%@page import="com.ryon.dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ryon.servlet.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String name = (String)session.getAttribute("name");
    ArrayList<MemberDTO> m1 = MemberDAO.select();
    MemberDTO mb = new MemberDTO();
	String name1 = mb.getName();
        if(name == null){
        	//로그인 안된사람
        	response.sendRedirect("login_form.jsp");
        }else{
        	//로그인 된 사람
        	System.out.println("로그인 된 사람 : "+ name);
        	MemberDAO m = new MemberDAO();
        	
        	
        	
        	
        	for(MemberDTO m2 : m1){
        		System.out.println(m2.getName());
        	}
        	
        	
        		
        	
        }
       
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인된사람만보이게하고싶당
<%= name %>님 반갑습니다.</br>
로그인 되었습니다.
<%


%>

<a href="logout.jsp">로그아웃</a>
</body>
</html>