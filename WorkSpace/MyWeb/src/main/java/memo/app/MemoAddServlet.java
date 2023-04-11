package memo.app;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//tomcat/lib/servlet-api.jar => Servlet 관련 라이브러리
//tomcat/lib/jsp=api=jar	 => JSP 관련 라이브러리
//jdbc driver => ojdbc6.jar를 복사하여 tomcat/lib아래 붙여넣기 하자
@WebServlet("/MemoAdd")
public class MemoAddServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out=res.getWriter();
		out.println("MemoAddServlet");
		//1. 사용자가 입력한 값 받아오기
		String name = req.getParameter("name");
		String msg = req.getParameter("msg");
		out.println(name+"/"+msg);
		
		//2. 유효성 체크(null, 빈문자열)
		if(name==null || msg==null||name.trim().isEmpty()||msg.trim().isEmpty()) {
			//out.println("잘못된 값 들어옴!!");
			//memo/input.html로 페이지 이동시키자
			res.sendRedirect("memo/input.html");
			//sendRedirect(): redirect방식으로 페이지를 이동시킨다.
			//				=> 브라우저의 url을 지정한 페이지로 변경한 뒤 서버에 새로운 요청을 발생시켜 이동한다
			return;
		}
		
		//3. [1] 번에서 받은 값을 MemoVO객체에 담아 준다
		MemoVO memo = new MemoVO(0, name, msg, null);
		
		//4. dao의 insertMemo()호출한다
		MemoDAO dao = new MemoDAO();
		try {
			int n=dao.insertMemo(memo);
		//5. 그 결과값에 따라 메시지 처리
			String str=(n>0)?"글 등록 성공":"글 등록 실패";
			String loc=(n>0)?"MemoList":"memo/input.html";
			//out.println(str);
			out.println("<script>");
			out.println("alert('"+str+"');");
			out.println("location.href='"+loc+"';");
			out.println("</script>");
		}catch (SQLException e) {
			e.printStackTrace();
			out.println("Error: "+e.getMessage()+"<br>");
		}
		
		out.close();
	}
}
