package com.ryon.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ryon.dto.MemberDTO;



public class MemberDAO {
	
	public static void select(int a) {
		//메소드 오버로딩 예제 1 
		//인자값으로 메소드를 구분하여 같은 이름의 메소드를 사용할 수 있게 한다.
	}
	public static MemberDTO selcet(String id,String pw,String name,String phone,String email) {
		return new MemberDTO();
		//메소드 오버로딩 예제 2
	}
	
	//데이터를 리스트로 가지고 오는 기능
	public static ArrayList<MemberDTO> select() {
		Connection conn = null; //db와 연결하는 변수
		PreparedStatement stmt = null; //sql 질의문 관리하는 기능
		ResultSet rs = null; //sql 결과값 저장
		ArrayList<MemberDTO> list = new ArrayList<>();
		//int result = 0;
		//MemberDTO dto = null;
		
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://localhost/dbdb?serverTimezone=Asia/Seoul";
			
			conn = DriverManager.getConnection(url, "root", "root");
			String sql = "SELECT * FROM member";
			stmt = conn.prepareStatement(sql);//db와 sql 연결
			//stmt.setString(1,uid); //'?'위치에 변수값을 넣는다. 
			//stmt.setString(2,upw);
			rs = stmt.executeQuery(sql);//연결된 db에 sql변수에 저장된 질의문으로 명령을 내리고 rs에 결과값을 저장. ResultSet에 반환한다.
			while(rs.next()) {
				//result = 1; //1이 로그인 성공
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				
				MemberDTO dto = new MemberDTO();
				
				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				dto.setPhone(phone);
				dto.setEmail(email);
				
				list.add(dto);
				
				//System.out.println(id+" "+pw+" "+name+" "+phone+" "+email);
				//MemberDTO dto = new MemberDTO();
				//dto.setUid(id);
				//dto.setUpw(pw);
			}
			

			// 3. 쿼리 수행을 위한 Statement 객체 생성
			
			

			// 4. SQL 쿼리 작성
			// 주의사항
			// 1) JDBC에서 쿼리를 작성할 때는 세미콜론(;)을 빼고 작성한다.
			// 2) SELECT 할 때 * 으로 모든 칼럼을 가져오는 것보다
			// 가져와야 할 칼럼을 직접 명시해주는 것이 좋다.
			// 3) 원하는 결과는 쿼리로써 마무리 짓고, java 코드로 후작업 하는 것은 권하지 않음
			// 4) 쿼리를 한 줄로 쓰기 어려운 경우 들여쓰기를 사용해도 되지만 띄어쓰기에 유의 !!
			
			// 5. 쿼리 수행
			// 레코드들은 ResultSet 객체에 추가된다.
			

			// 6. 실행결과 출력하기
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러 " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list; //초기화된 result값을 반환. 반환된 값은 연결해둔 서블릿으로 간다.
		//return dto; //dto로 반환한다
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lcheck a = new lcheck();
		
		
		

	}

}
