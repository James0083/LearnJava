package memo.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import memo.app.*;
import java.util.*;
import java.sql.*;

@WebServlet("/MemoList")
public class MemoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		
		//1. MemoDAO객체 생성해서 전체 메모 목록 가져오는 메서드 호출 - listMemo()
		MemoDAO dao = new MemoDAO();
		try {
			List<MemoVO> arr = dao.listMemo();
			req.setAttribute("memoArr", arr);
			//req.setAttribute(key값, value값)
			//모델 통해 가져온 데이터를 req에 저장한뒤 View페이지로 이동한다.
			//==>이때 주의. redirect방식이 아니라 forward방식으로 이동해야 한다.
			
			RequestDispatcher disp=req.getRequestDispatcher("memo/list.jsp");
			disp.forward(req, res); //forward방식으로 view페이지로 페이지 이동을 한다.
			//forward방식은 req, res를 가지고 간다.
			
//			res.sendRedirect("memo/list.jsp");
			
			//redirect: 브라우저의 url을 변경해서 새로운 request를 발생시키는 방식으로 이동
			//forward: 서버 내부에서 페이지 이동을 한다. 따라서 브라우저는 이동한 url을 알지 못한다.
		}catch (SQLException e) {
			e.printStackTrace();
			out.println("Error: "+e.getMessage()+"<br>");
		}
		
		
		out.close();
	}
}
