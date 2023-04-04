package day03;
import java.sql.*;
import common.util.DBUtil;

public class EmpSelect {

	public static void main(String[] args) throws Exception{
		Connection con=DBUtil.getCon();
		//EMP의 모든 정보를 가져오자
//		String sql = "SELECT * FROM emp ORDER BY empno ASC";
		//lpad(), rpad()
		String sql = "SELECT empno, ename, rpad(job,12,' ') job,";
			sql+="rpad(mgr,10,' ') mgr, hiredate,";
			sql+="lpad(sal,10,' ') sal, lpad(comm,10,' ') comm,";
			sql+="deptno from emp order by 1";
		System.out.println(sql);
		Statement st=con.createStatement();
		
		//boolean execute(): 모든 sql문 실행
		//int extcuteUpdate(): DML문장 실행
		//ResultSet extcuteQuery(): DQL문장 (select문) 실행
		ResultSet rs=st.executeQuery(sql);
		
		//반복문 돌면서 데이터 꺼내 출력하세요
		while(rs.next()) {
			int no=rs.getInt(1);
			String name=rs.getString(2);
			String job=rs.getString(3);
			int mgr=rs.getInt(4);
			Date hdate=rs.getDate(5);
			int sal=rs.getInt(6);
			int comm=rs.getInt(7);
			int dno=rs.getInt(8);
			System.out.printf("%d\t%s\t%12s\t%d\t%s\t%d\t%d\t%d\n", 
					no, name, job, mgr, hdate.toString(), sal, comm, dno);
		}
		
		//자원반납
		if(rs!=null) rs.close();
		if(st!=null) st.close();
		if(con!=null) con.close();
	}

}
