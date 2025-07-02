package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass04 {
	public static void main(String[] args) {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url, "scott", "TIGER");
			System.out.println("Oracle DB 접속 성공");
		}catch (Exception e) {
			e.printStackTrace();
		}
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="""
					SELECT empno, ename, deptno, dname
					FROM emp
					JOIN dept USING(deptno)
					ORDER BY empno ASC
					""";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				int deptno=rs.getInt("deptno");
				String dname=rs.getString("dname");
				String info = String.format("사원번호: %d 사원이름:%s 부서번호:%d 부서명:%s",
						empno, ename, deptno, dname);
				System.out.println(info);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
