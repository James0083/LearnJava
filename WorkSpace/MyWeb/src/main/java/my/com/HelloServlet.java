package my.com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
/* Servlet : Server Side Applet
 * [1] HttpServlet클래스를 상속받아 구현한다
 *  => http프로토콜에 특화된 서블릿
 * [2] doGet() 또는 doPost() 메서드를 오버라이드 한다
 * 
 * [3] MyWeb/src/main/webapp
 * 						+---WEB-INF
 * 								+---web.xml (deployment descriptor)
 * 
 * 	- web.xml에 서블릿을 등록하던지
 * 	- 어노테이션(@WebServlet)을 기술해야 한다
 *  */
public class HelloServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//req : 사용자 요청과 관련된 정보를 다루는 객체
		//res : 브라우저와 연결되어 브라우저에 동적으로 html을 생성해서 쓸 수 있는 객체
		res.setContentType("text/html; charset=UTF-8");//default charset ISO-8859-1
		//브라우저에 보여줄 문서형식(마임 타밉, 컨텐트 타입)을 지정
		
		PrintWriter pw=res.getWriter();
		
		pw.println("<h1>Hello Servlet</h1>");
		//브라우저에 html을 동적으로 만들어서 쓴다
		pw.println("<h2>안녕 서블릿</h2>");
		Date d=new Date();
		String dateStr=d.toString();
		pw.println("<h2 style='color:red'>"+dateStr+"</h2>");
		
		pw.close();
	}
}
