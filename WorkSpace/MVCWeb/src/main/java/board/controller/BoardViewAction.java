package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;

public class BoardViewAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//1. 글번호(num) 받기
		String numStr = req.getParameter("num");
		//2. 유효성 체크 => boardList.do redirect 이동
		if(numStr==null || numStr.trim().isEmpty()) {
			this.setViewPage("boardList.do");
			this.setRedirect(true);
			return;
		}
		int num = Integer.parseInt(numStr);
		//3_1. 조회수 증가
		BoardDAO dao = new BoardDAO();
		boolean b=dao.updateReadnum(num);
		
		//3_2. dao의 viewBoard(글번호) 호출
		BoardVO board = dao.viewBoard(num);
		
		//4. req에 저장
		req.setAttribute("board", board);
		
		//5. 뷰페이지 지정,이동방식 지정
		this.setViewPage("/board/boardView.jsp");
		this.setRedirect(false);
	}

}
