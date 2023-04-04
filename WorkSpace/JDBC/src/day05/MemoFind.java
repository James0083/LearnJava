package day05;
import java.sql.*;
import javax.swing.*;
import common.util.*;
//검색어를 입력하면 해당 검색어를 갖는 메모글을 가져오는 프로시저를 작성하고
//자바와 연동시키세요
public class MemoFind {

	public static void main(String[] args) 
	throws Exception
	{
		String findStr = JOptionPane.showInputDialog("검색어를 입력하세요");
		if(findStr==null) return;
		String sql = "{call memo_find(?,?)}";
		Connection con=DBUtil.getCon();
		CallableStatement cs=con.prepareCall(sql);
		
		cs.setString(1, findStr);
		cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
		cs.execute();
		
		ResultSet rs = (ResultSet)cs.getObject(2);
		
		System.out.println("--"+findStr+"로 검색한 내용--------------------");
		while (rs.next()) {
			int no=rs.getInt(1);
			String name =rs.getString(2);
			String msg=rs.getString(3);
			java.sql.Date hdate=rs.getDate(4);
			System.out.println(no+"\t"+name+"\t"+msg+"\t"+hdate);
		}//while--------------
		rs.close();
		cs.close();
		con.close();
		
	}

}

/*
create or replace procedure memo_find
(
    fstr in VARCHAR2,
    mycr out sys_refcursor
)
is
begin
    open mycr for 
    select no, name, msg, wdate
    from memo where msg like '%'||fstr||'%';
end;
/
 */