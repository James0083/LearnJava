package day01;
import java.sql.*;

public class JDBCTest {

	public static void main(String[] args) {
		//1. Driver Loading
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loading 성공~~");
		//2. 오라클 DB에 접속 : DriverManager클래스의 getConnection()메서드 이용
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
					//프로토콜:dbms유형:드라이버타입:@DB서버host:port:전역데이터베이스명
		String user="scott", pwd="tiger";
		Connection con=DriverManager.getConnection(url,user,pwd);
		System.out.println("DB Connected!!");
		
		//3. SQL문을 작성
		String sql = "CREATE TABLE memo (no number(4) primary key,";
				sql+="name varchar2(30) not null,";
				sql+="msg varchar2(100),";
				sql+="wdate date default sysdate)";
		
		//4. Statement객체를 Connection의 createStatement()메서드를 이용해서 얻어온다
		Statement stmt = con.createStatement();
		
		//5. execute() / executeUpdate() / executeQuery() 메서드 중 하나를 이용해서 SQL문을 실행시킨다
		boolean b=stmt.execute(sql); //sql문을 실행시킴
		System.out.println("b: "+b); //select문을 실행시키면 true를 반환, 그 외의 문장을 실행시키면 false를 반환
		
		//6. DB와 연결된 자원을 반납 => 반드시 실행해야 함. 순서 중요!!
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();
		
		
		}catch (ClassNotFoundException e) {
			System.out.println("Driver Loading 실패!!");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("DB연결 중 에러 발생!!");
			e.printStackTrace();
		}

	}

}
