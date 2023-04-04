package day02;
import java.util.*;
import java.sql.*;

public class MemoInsert {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("작성자 : ");
		String name = sc.nextLine();
		System.out.println("메모 내용 : ");
		String msg = sc.nextLine();
		System.out.println(name+"/"+msg);
		
		//1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott", pwd="tiger";
		
		//2. DB 연결
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB연결 성공!");
		
		//3. SQL문 작성
		String sql = "INSERT INTO MEMO(no, name, msg, wdate)";
				sql+=" VALUES (MEMO_SEQ.NEXTVAL, '" + name + "', '" + msg + "', SYSDATE)";
		System.out.println(sql);
		
		//4. Statement 얻어오기
		Statement stmt = con.createStatement();
		
		//5. execute() 호출
		//	public int executeUpdate(String sql) : INSERT/DELETE/UPDATE문을 실행시키고자 할 때
		
//		boolean b = stmt.execute(sql);
//		System.out.println("b : "+b);
//		System.out.println("데이터 삽입 성공!!");
		int b = stmt.executeUpdate(sql);
			// sql문에 의해 영향받은 레코드 개수를 반환한다
		
		System.out.println(b+"개의 레코드를 등록했어요!!");
		
		System.out.println((b>0)? "글쓰기 성공":"글쓰기 실패");
		
		//6. DB자원 반납
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();
	}

}
