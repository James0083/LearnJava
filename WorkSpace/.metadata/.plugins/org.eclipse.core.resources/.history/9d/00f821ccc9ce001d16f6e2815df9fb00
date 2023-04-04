package day04;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import common.util.DBUtil;
//PreparedStatement 활용
public class EmpFind {

	public static void main(String[] args) throws Exception {
		//검색할 사원의 이름 키워드(like)를 입력받아서 해당 사원정보를 출력하세요
		//사번, 사원명, 부서명, 담당업무, 입사일, 근무지 가져와 출력하기
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사원의 이름 키워드 : ");
		String name_key = sc.nextLine();
		
		Connection con = DBUtil.getCon();
		String sql = "SELECT EMPNO, ENAME, DNAME, JOB, HIREDATE, LOC ";
		sql += " FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%"+name_key+"%");

		
		ResultSet rs=ps.executeQuery();
		
		//반복문 돌면서 데이터 꺼내 출력하세요
		while(rs.next()) {
			int empno=rs.getInt("empno");
			String ename=rs.getString("ename");
			String dname=rs.getString("dname");
			String job=rs.getString("job");
			java.sql.Date hdate=rs.getDate("hiredate");
			String loc=rs.getString("loc");
			System.out.printf("%d\t %s\t %s\t %s\t %s\t %s\n", 
					empno, ename, dname, job, hdate.toString(), loc);
		}
		
		if(rs!=null) rs.close();
		if(ps!=null) ps.close();
		if(con!=null) con.close();

	}

}
