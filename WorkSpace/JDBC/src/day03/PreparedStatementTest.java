package day03;
import java.sql.*;
import java.util.Scanner;

import common.util.DBUtil;
/*
 * Statement
 * 	+----PreparedStatement
 * 			: sql문을 미리 dbms 포맷에 맞게 컴파일 시켜 준비시켜 놓는다.
 * 				Statement보다 DB와 연동하는 속도가 훨씬 빠름
 */

public class PreparedStatementTest {

	public static void main(String[] args) 
	throws Exception
	{
		//메모글을 수정하는 문장을 작성해봅시다.
		Scanner sc=new Scanner(System.in);
		System.out.println("작성자 : ");
		String name=sc.nextLine();
		
		System.out.println("수정할 메모 내용 : ");
		String msg=sc.nextLine();
		
		Connection con=DBUtil.getCon();
		String sql="update memo set msg=?, wdate=sysdate where name=?";
		//? : IN PATAMETER
		//변경될 값을 인 파라미터로 넣어준다
		
		PreparedStatement ps=con.prepareStatement(sql);//sql문을 미리 컴파일시킨다
		
		//인 파라미터 값을 setting
		ps.setString(1, msg);
		ps.setString(2, name);
		
		int n=ps.executeUpdate();
		
		System.out.println((n>0)?"글 수정 성공":"수정 실패");
		
		if(ps!=null) ps.close();
		if(con!=null) con.close();
		

	}

}
