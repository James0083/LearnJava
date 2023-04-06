package memo.app;

import java.sql.*;
import common.util.*;
import java.util.*;
import java.util.Date;
/**
 * @author a
 * 영속성 계층(Persistence Layer)에 속함
 * DAO(Date Access Object) : 데이터베이스에 접근해서 CRUD의 로직을 수행하는 객체
 * => Model에 속함
 */
public class MemoDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	/**
	 * 한줄 메모장에 insert문을 수행하는 메서드
	 */
	public int insertMemo(MemoVO memo) throws SQLException{
		try {
			con=DBUtil.getCon();
			//String : 불변성(immutable) : 원본은 불변함 => 편집할 경우 새로운 객체를 만들고 기존 객체에 대한 포인터를 회수해 새로운 객체를 가리킨다
	/*		String sql="insert into";
					sql += " memo values(";
					sql += ")"; */
			//StringBuffer, StringBuilder : 문자열 편집 작업이 가능한 클래스
			//								문자열을 메모리 버퍼에 넣고 수정, 삽입, 삭제 등을 수행함
			StringBuilder buf=new StringBuilder("insert into memo(no, name, msg, wdate)")
							.append(" values(memo_seq.nextval, ?, ?, sysdate)");
			String sql=buf.toString();
			
			ps=con.prepareStatement(sql);
			ps.setString(1, memo.getName());
			ps.setString(2, memo.getMsg());
			
			int n=ps.executeUpdate();
			return n;
		}finally {
			//db 연결자원 반납
			close();
		}
	}//-------------------------
	
	/**전체 메모글을 가져오는 메서드
	 * 	 */
	public List<MemoVO> listMeno() throws SQLException{
		try {
			con=DBUtil.getCon();
			StringBuilder buf=new StringBuilder("SELECT rpad(no,10,' ') no, rpad(name,16,' ') name,")
							.append("rpad(msg,100,' ') msg, wdate FROM memo ORDER BY no DESC");
			String sql=buf.toString();
			
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			List<MemoVO> arr=new ArrayList<>();
			while(rs.next()) {
				int no=rs.getInt("no"); //별칭으로 꺼내옴
				String name=rs.getString("name");
				String msg=rs.getString("msg");
				java.sql.Date wdate=rs.getDate("wdate");
				
				MemoVO memo=new MemoVO(no,name,msg,wdate);//record
				arr.add(memo);//table
			}//while---------------
			return arr;
			
		}finally {
			close(); //DB관련한 자원들을 반납
		}
	}
	
	/**
	 * DB관련한 자원들을 반납하는 메서드
	 */
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}//////////////////////////////
