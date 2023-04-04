package day03;
import java.sql.*;
import java.util.*;

import common.util.DBUtil;

public class EmpInsert {

	public static void main(String[] args) 
	throws Exception{
		//emp테이블에 사번,이름,업무,부서번호,급여를 입력받아서 insert문을 실행시키세요
		//[PreparedStatement를 이용해서]
		Scanner sc=new Scanner(System.in);
		
		System.out.println("사번 : ");
		int empno = sc.nextInt();
		sc.nextLine();
		System.out.println("이름 : ");
		String name = sc.nextLine();		
		System.out.println("업무 : ");
		String job = sc.nextLine();		
		System.out.println("부서번호 : ");
		int deptno = sc.nextInt();		
		System.out.println("급여 : ");
		int sal = sc.nextInt();
		
		Connection con = DBUtil.getCon();
		
		String sql = "INSERT INTO emp (empno, ename, job, hiredate, deptno, sal)";
			sql += " values (?, ?, ?, SYSDATE, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, empno);
		ps.setString(2, name);
		ps.setString(3, job);
		ps.setInt(4, deptno);
		ps.setInt(5, sal);
		
		System.out.println(ps);
		
		int n=ps.executeUpdate();
		
		System.out.println((n>0)?"사원 추가 성공":"추가 실패");
		
		if(ps!=null) ps.close();
		if(con!=null) con.close();
		
		
	}

}
