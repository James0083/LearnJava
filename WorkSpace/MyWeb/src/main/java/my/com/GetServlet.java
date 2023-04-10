package my.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web.xml에 서블릿 등록 대신 annotation을 이용해 등록한다
 * @WebServlet("/url패턴") [주의] url패턴은 unique한 이름이어야 함
 */
@WebServlet("/GetTest")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//get방식의 요청을 처리하기 위해서는 doGet()을 이용해야함
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>GetServlet</h1>");
		out.println("<h2>Get방식의 요청을 처리할 때는 doGet()을 오버라이드 합니다</h2>");
		//요청 데이터 받기 => req를 이용해서 받는다
		//String getParameter("파라미터명")
		String name = req.getParameter("name"); 
		String userid = req.getParameter("userid");

		out.println("<h3> 이 름 : "+name+"</h3>");
		out.println("<h3> 아이디 : "+userid+"</h3>");
		
		out.close();
		
	}

}
