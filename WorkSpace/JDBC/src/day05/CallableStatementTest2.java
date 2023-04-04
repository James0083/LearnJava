package day05;
import java.sql.*;
import javax.swing.*;
import common.util.DBUtil;
/*
create or replace procedure emp_forjava
(
    pdno in emp.deptno%type,
    mycr out sys_refcursor
)
is
begin
//    open mycr for
//    select ename,job, dname, loc, hiredate
//    from dept d join emp e
//    on d.deptno = e.deptno and e.deptno=pdno;
    open mycr for
    select ename, job, dname, loc, hiredate from 
    (select * from emp where deptno=pdno) A join dept d
    on a.deptno=d.deptno;
end;
/
 * ----------------------------------------------------
 */
public class CallableStatementTest2 {

	public static void main(String[] args) 
	throws Exception
	{
		String dnoStr=JOptionPane.showInputDialog("검색할 부서 번호를 입력하세요");
		if(dnoStr==null) return;
		Connection con = DBUtil.getCon();
		String sql="{call emp_forjava(?,?)}";
		CallableStatement cs=con.prepareCall(sql);
		//int parameter값 셋팅: setXXX()
		//out parameter값 셋팅: registerOutParameter()
		cs.setInt(1, Integer.parseInt(dnoStr));
		cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
		cs.execute();
		
		//cursor는 ResultSet과 호환된다
		ResultSet rs = (ResultSet)cs.getObject(2);
		
		System.out.println("--"+dnoStr+"번 부서 사원 목록--------------------");
		while (rs.next()) {
			String name=rs.getString(1);
			String job =rs.getString(2);
			String dname=rs.getString(3);
			String loc=rs.getString(4);
			java.sql.Date hdate=rs.getDate(5);
			System.out.println(name+"\t"+job+"   \t"+dname+"\t"+loc+"\t"+hdate);
		}//while--------------
		rs.close();
		cs.close();
		con.close();
	}

}
