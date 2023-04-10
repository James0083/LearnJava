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
	public List<MemoVO> listMemo() throws SQLException{
		try {
			con=DBUtil.getCon();
			StringBuilder buf=new StringBuilder("SELECT rpad(no,10,' ') no, rpad(name,16,' ') name,")
							.append("rpad(msg,100,' ') msg, wdate FROM memo ORDER BY wdate DESC");
			String sql=buf.toString();
			
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			List<MemoVO> arr=makeList(rs);
			return arr;
			
		}finally {
			close(); //DB관련한 자원들을 반납
		}
	}//---------------------------------------
	
	public List<MemoVO> makeList(ResultSet rs) throws SQLException{
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
	}
	
	/**
	 * 글 번호(PK)로 메모글을 가져오는 메서드
	 */
	public MemoVO selectMemo(int no) throws SQLException{
		try {
			con=DBUtil.getCon();
			String sql = "SELECT no, name, msg, wdate FROM memo WHERE no=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			rs=ps.executeQuery();
			List<MemoVO> arr = makeList(rs);
			if(arr!=null && arr.size()==1) {
//				MemoVO memo = arr.get(0);
//				return memo;//해당 글을 반환
				return arr.get(0);
			}
			return null;//해당 글이 없을 경우

		}finally {
			close();
		}
	} 
	
	/** keyword로 메모 글 내용을 검색하는 메서드
	 * */
	public List<MemoVO> findMemo(String keyword) throws SQLException{
		try {
			con=DBUtil.getCon();
			StringBuilder buf = new StringBuilder("SELECT rpad(no,10,' ') no,")
						.append(" rpad(name,16,' ') name, rpad(msg,100,' ') msg, wdate FROM memo")
						.append(" WHERE msg LIKE ?");
			String sql=buf.toString();
			ps= con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs= ps.executeQuery();
			List<MemoVO> arr = makeList(rs);
			return arr;
		} finally {
			close();
		}
	}
	
	/**
	 * 메모 글 내용, 작성자를 수정하는 메서드
	 */
	public int updateMemo(MemoVO vo) throws SQLException{
		try {
			con=DBUtil.getCon();
			String sql = "UPDATE memo SET name=?, msg=? WHERE no=?";
			ps= con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getMsg());
			ps.setInt(3, vo.getNo());
			
			return ps.executeUpdate();
		} finally {
			close();
		}
	}
	
	/**
	 * 글 번호로 매모글을 삭제하는 메서드
	 * @param no
	 * @return 
	 */
	public int deleteMemo(int no) throws SQLException{
		try {
			con=DBUtil.getCon();
			String sql = "DELETE FROM memo WHERE no=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			return ps.executeUpdate();
			
		}finally {
			close();
		}
	}//--------------------------------
	
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
