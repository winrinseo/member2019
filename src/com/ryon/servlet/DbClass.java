package com.ryon.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbClass {
	
	public static int insert(String id, String pw, String name, String email, String phone, String address,
			String birthday) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int count = 0; // 외부로 보낼 결과값 0이면 실패 1이면 성공

		try {
// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

// 2. 연결하기
			String url = "jdbc:mysql://localhost/dbdb?serverTimezone=Asia/Seoul";
			conn = DriverManager.getConnection(url, "root", "root");

// 3. SQL 쿼리 준비
// 추가하려는 데이터의 값은 전달된 인자를 통해 동적으로 할당되는 값이다.
// 즉 어떤 값이 전달될지 모르므로 Select 할 때와 달리
// stmt = conn.createStatement(); 를 작성하지 않고
// pstmt = conn.prepareStatement(sql); 로 작성하여 데이터를 추가할 것임을 알립니다.
// 물론 sql 쿼리 내에서 + 연산자로 한 줄로 작성할 수 있지만 가독성이 너무 떨어지게 되므로
// 이 방법을 권합니다.
			String sql = "INSERT INTO member VALUES (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

// 4. 데이터 binding
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			pstmt.setString(6, address);
			pstmt.setString(7, birthday);

// 5. 쿼리 실행 및 결과 처리
// SELECT와 달리 INSERT는 반환되는 데이터들이 없으므로
// ResultSet 객체가 필요 없고, 바로 pstmt.executeUpdate()메서드를 호출하면 됩니다.
// INSERT, UPDATE, DELETE 쿼리는 이와 같이 메서드를 호출하며
// SELECT에서는 stmt.executeQuery(sql); 메서드를 사용했었습니다.
// @return     int - 몇 개의 row가 영향을 미쳤는지를 반환
			count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러 " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//insert(String id,String pw,String name,String email,String address,String birthday);
		DbClass mc = new DbClass();
		


	}

}
