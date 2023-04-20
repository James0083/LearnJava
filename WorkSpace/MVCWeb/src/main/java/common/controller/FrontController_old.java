package common.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(
		urlPatterns = { "*.me" },
		initParams = {
				@WebInitParam(name = "config", value = "파일경로")
		})
public class FrontController_old extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}

	
	
	private void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//System.out.println("process()");
		//http://localhost:7070/MVCWeb/index.do ==> URL
		//1. 클라이언트의 요청
		String uri=req.getRequestURI();
		System.out.println("uri: "+uri);	//"/MVCWeb/index.do" ==> index.jsp보여주기
											//"/MVCWeb/test.do"  ==> hello.jsp보여주기
		String ctx=req.getContextPath(); 	//"/MVCWeb"
		String cmd=uri.substring(ctx.length());
		System.out.println("cmd: "+cmd);
		
		boolean isRedirect=true;
		String viewPage="";
		
		if(cmd.equals("/index.do")) {
			req.setAttribute("msg", "Hi MVCWeb Index Page");
			viewPage="index.jsp";
		}else if(cmd.equals("/test.do")) {
			req.setAttribute("msg", "Hello MVCWeb Hello Page");
			viewPage="hello.jsp";
		}
		
		//페이지 이동-------
		if(isRedirect) {
			res.sendRedirect(viewPage);
		}else {
			//forward방식으로 이동
			RequestDispatcher disp=req.getRequestDispatcher(viewPage);
			disp.forward(req, res);
		}
	}



	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}

}
