package day04;
/*
[실습 1]
memo테이블 관련
글내용을 수정하는 프로시저를 작성해봅시다.
인파라미터로
(글번호,  수정할 작성자명, 수정할 메모글)
을 입력받아 해당 글번호 글의 작성자명과 메모내용을 수정하는 
프로시저를 작성하세요
프로시저명: memo_edit
--------------------------------------------------------
[실습 2] Java class명: MemoUpdate
memo_edit프로시저를 호출하는 jdbc코드를 구현하세요
--------------------------------------------------------

CREATE OR REPLACE PROCEDURE MEMO_EDIT
(ENO NUMBER, ENAME VARCHAR2, EMSG VARCHAR2)
IS
BEGIN
    UPDATE MEMO SET NAME=ENAME, MSG=EMSG, WDATE=SYSDATE WHERE NO=ENO;
    COMMIT;
END;
/
*/
import java.sql.*;
import javax.swing.*;
import common.util.*;
public class MemoUpdate {

	public static void main(String[] args) throws Exception{
		String eno=JOptionPane.showInputDialog("수정할 글 번호 : ");
		String ename=JOptionPane.showInputDialog("수정할 작성자 : ");
		String emsg=JOptionPane.showInputDialog("수정할 메모글 : ");
		
		if(eno==null||ename==null||emsg==null) return;
		
		Connection con = DBUtil.getCon();
		String sql = "{call memo_edit(?,?,?)}";
		CallableStatement cs = con.prepareCall(sql);
		
		cs.setInt(1, Integer.parseInt(eno));
		cs.setString(2, ename);
		cs.setString(3, emsg);
		
		cs.execute();
		System.out.println("메모 글 수정 성공!!");
		
		cs.close();
		con.close();

	}

}
