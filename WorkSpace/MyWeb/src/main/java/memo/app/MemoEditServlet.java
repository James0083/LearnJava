package memo.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//---------------------------------------------------
//[실습] MemoEditServlet클래스 생성
//=>url-pattern은 /MemoEdit으로 설정
//[1] 사용자가 입력한 값 받기(no,name,msg)
//[2] 유효성 체크
//=> redirect로 이동 MemoList로
//[3] MemoVO에 담아주기
//[4] MemoDAO의  updateMemo()호출
//[5] 그 실행결과 메시지,이동 경로 처리
//---------------------------------------------------
@WebServlet("/MemoEdit")
public class MemoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		//[0] Post방식일 때 한글 인코딩 설정
		req.setCharacterEncoding("utf-8");
		
//		[1] 사용자가 입력한 값 받기(no,name,msg)
		String noStr = req.getParameter("no");
		String name = req.getParameter("name");
		String msg = req.getParameter("msg");
		
//		[2] 유효성 체크
//		=> redirect로 이동 MemoList로
		if(noStr==null || name==null || noStr.trim().isEmpty() || name.trim().isEmpty()) {
			res.sendRedirect("MemoList");
			return;
		}
		
//		[3] MemoVO에 담아주기
		MemoVO memo = new MemoVO(Integer.parseInt(noStr), name, msg, null);
//		[4] MemoDAO의  updateMemo()호출
		MemoDAO dao = new MemoDAO();
		try {
			int n = dao.updateMemo(memo);
//		[5] 그 실행결과 메시지,이동 경로 처리
			String str = (n>0)? "글 수정 성공":"글 수정 실패";
			String loc = "MemoList";
			out.println("<script>");
			out.println("alert('"+str+"');");
			out.println("location.href = '"+loc+"';");
			out.println("</script>");
		}catch (SQLException e) {
			e.printStackTrace();
			out.println("Error: "+e.getMessage()+"<br>");
		}
		
		out.close();
	}

}



