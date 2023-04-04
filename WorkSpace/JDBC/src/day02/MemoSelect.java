package day02;
import java.sql.*;
import common.util.*;

public class MemoSelect {

	public static void main(String[] args) throws SQLException{
		Connection con=DBUtil.getCon();
//		System.out.println(con);
		String sql="SELECT no, name, msg, wdate FROM memo ORDER BY no DESC";
		
		Statement st=con.createStatement();
		
		boolean b= st.execute(sql); //SELECT문이면 true반환
		System.out.println("b: "+b);
		if(b) {//select문이라면 => 결과 테이블 (ResultSet) 
			ResultSet rs=st.getResultSet();
			
			//ResultSet의 메서드
			//boolean next(): 논리적인 커서를 이동시켜서 가리키고 있는 곳에 레코드가 있으면 true를 반환하고, 없으면 false를 반환한다
			//			논리적인 커서는 처음에 before first에 위치한다
			
			while (rs.next()) {
				int no=rs.getInt("no"); //컬럼명, 컬럼 인덱스(1부터 시작)
				String name=rs.getString("name");
				String msg=rs.getString("msg");
				java.sql.Date wdate=rs.getDate("wdate");
				System.out.println(no+"\t"+name+"\t"+msg+"\t"+wdate);
			}//while--------------
			
			if(rs!=null) rs.close();
			
		}else {//select문이 아니라면 (ex DML, DDL, ...)
			int n=st.getUpdateCount();
			System.out.println(n+"개의 레코드가 변경되었습니다");
		}
		
		if(st!=null) st.close();
		if(con!=null) con.close();

	}

}
