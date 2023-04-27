package board.model;
import java.sql.*;
import java.util.*;

import common.util.DBUtil;

public class BoardDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public int insertBoard(BoardVO vo) throws SQLException{
		try {
			con=DBUtil.getCon();
			StringBuilder buf = new StringBuilder("insert into board(num,userid,subject")
					.append(" ,content, wdate, readnum, filename,filesize)")
					.append(" values(board_seq.nextval,?,?,?,systimestamp,0,?,?)");
			String sql=buf.toString();
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getUserid());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getFilename());
			ps.setLong(5, vo.getFilesize());
			
			return ps.executeUpdate();
		} finally {
			close();
		}
	}//--------------------------------------------
	
	public List<BoardVO> listBoard() throws SQLException{
		try {
			con=DBUtil.getCon();
			String sql="select * from board order by num desc";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			return makeList(rs);
		} finally {
			close();
		}
	}//-------------------------------️

	public List<BoardVO> listBoard(int start, int end) throws SQLException {
		try {
			con=DBUtil.getCon();
			StringBuilder buf=new StringBuilder("select * from ( ")
					.append(" select rownum rn, A.* from ")
					.append(" (select * from board order by num desc) A )")
					.append(" where rn between ? and ?");
			String sql=buf.toString();
			ps=con.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs=ps.executeQuery();
			return makeList(rs);
		} finally {
			close();
		}
	}//-------------------------------️

	public List<BoardVO> listBoard(int start, int end, String findType, String findKeyword) throws SQLException {
		try {
			con=DBUtil.getCon();
			String colName=getColumName(findType);	//검색유형 관련한 컬럼명 얻어오기
			StringBuilder buf=new StringBuilder("select * from ( ")
					.append(" select rownum rn, A.* from ")
					.append(" (select * from board where "+colName+" like ? ")
					.append(" order by num desc) A ) ")
					.append(" where rn between ? and ?");
			String sql=buf.toString();
			System.out.println(sql);
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+findKeyword+"%");
			ps.setInt(2, start);
			ps.setInt(3, end);
			rs=ps.executeQuery();
			return makeList(rs);
			
		} finally {
			close();
		}
	}//-------------------------------️
	
	public List<BoardVO> makeList(ResultSet rs) throws SQLException {
		List<BoardVO> arr=new ArrayList<>();
		while(rs.next()) {
			int num=rs.getInt("num");
			String userid=rs.getString("userid");
			String subject=rs.getString("subject");
			String content=rs.getString("content");
			Timestamp wdate=rs.getTimestamp("wdate");
			int readnum=rs.getInt("readnum");
			String filename=rs.getString("filename");
			long filesize=rs.getInt("filesize");
			BoardVO vo=new BoardVO(num, userid, subject, content, wdate, readnum, filename, filesize);
			arr.add(vo);
		}
		
		return arr;
	}//---------------------------------
	
	public String getColumName(String type) {
		String colName="";
		switch (type) {
		case "1": colName="subject"; break;
		case "2": colName="userid"; break;
		case "3": colName="content"; break;
		}
		return colName;
	}//-----------------------------------
	
	public int getTotalCount(String type, String keyword) throws SQLException {
		try {
			con=DBUtil.getCon();
			StringBuilder buf=new StringBuilder("select count(num) cnt from board ");
			if(!type.trim().isEmpty() && !keyword.trim().isEmpty() ) {
				String colName=getColumName(type);
				
				buf.append(" where "+colName+" like ?");
			}
			String sql=buf.toString();
			System.out.println(sql);
			ps=con.prepareStatement(sql);
			if(!type.trim().isEmpty() && !keyword.trim().isEmpty() ) {
				ps.setString(1, "%"+keyword+"%");
			}
			rs=ps.executeQuery();
			rs.next();
			int cnt=rs.getInt(1);
			return cnt;
		} finally {
			close();
		}
	}
	
	/**글번호(num-pk)로 글내용 보기*/
	public BoardVO viewBoard(int num) throws SQLException {
		try {
			con=DBUtil.getCon();
			String sql="select * from board where num=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,num);
			rs=ps.executeQuery();
			List<BoardVO> arr=makeList(rs);
			if(arr==null||arr.size()==0)
				return null;
			
			return arr.get(0);
		} finally {
			close();
		}
	}//-------------------------------------
	
	/**글삭제*/
	public int deleteBoard(int num) throws SQLException{
		try {
			con=DBUtil.getCon();
			String sql="delete from board where num=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,num);
			return ps.executeUpdate();
		} finally {
			close();
		}
	}//----------------------------------
	
	public int updateBoard(BoardVO vo) throws SQLException {
		try {
			con=DBUtil.getCon();
			StringBuilder buf=new StringBuilder("update board set subject=?, ")
					.append(" content=?, wdate=systimestamp");
					//첨부파일이 있다면 
					if(vo.getFilename()!=null && !vo.getFilename().trim().isEmpty()) {
						buf.append(", filename=?, filesize=? ");
					}
					buf.append(" where num=?");
			String sql=buf.toString();
			System.out.println(sql);
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getSubject());
			ps.setString(2, vo.getContent());
			if(vo.getFilename()!=null && !vo.getFilename().trim().isEmpty()) {
				ps.setString(3, vo.getFilename());
				ps.setLong(4, vo.getFilesize());
				ps.setInt(5, vo.getNum());
			}else {
				ps.setInt(3, vo.getNum());
			}
			return ps.executeUpdate();
		} finally {
			close();
		}
	}//-------------------------------
	
	public boolean updateReadnum(int num) throws SQLException {
		try {
			con=DBUtil.getCon();
			String sql="update board set readnum=readnum+1 where num=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, num);
			int n=ps.executeUpdate();
			return (n>0)? true:false;
		} finally {
			close();
		}
	}//---------------------------------
	
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//-----------------------


	
}
