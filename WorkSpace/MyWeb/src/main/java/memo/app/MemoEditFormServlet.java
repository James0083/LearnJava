package memo.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//--------------------------------------------------
//1. 글번호로 글 내용 보여주기
// =>MemoVO selectMemo(글번호)
// => req에 저장해서
// ==> edit.jsp로 forward 이동
//--------------------------------------------------
//2. 수정 처리
// => updateMemo(MemoVO객체)
// => 메시지 보여주고 MemoList로 이동
//---------------------------------------------------
/**
 * Servlet implementation class MemoEditFormServlet
 */
@WebServlet("/MemoEditForm")
public class MemoEditFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out=res.getWriter();
		//1. 글 번호 받기
		String noStr = req.getParameter("no");
		//2. 유효성 테크 => redirect이동 MemoList로
		if(noStr==null || noStr.trim().isEmpty()) {
			res.sendRedirect("MemoList");
			return;
		}
		//3. MemoDAO의 selectMemo()호출
		//=> 반환되는 MemoVO객체를 req에 저장 => key값: memo
		MemoDAO dao = new MemoDAO();
		try {
			MemoVO vo = dao.selectMemo(Integer.parseInt(noStr.trim()));
			req.setAttribute("memo", vo);
		//4. memo/edit.jsp로 forward이동하기 위해 RequestDispatcher얻어오기
			RequestDispatcher disp = req.getRequestDispatcher("memo/edit.jsp");
		//5. forward()호출해서 이동
			disp.forward(req, res);
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("Error: "+e.getMessage()+"<br>");
		}
		
		out.close();
	}

}
