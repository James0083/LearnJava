package board.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;

public class BoardDeleteAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//1. 글번호 받기
		String numStr=req.getParameter("num");
		//2. 유효성 체크
		if(numStr==null || numStr.trim().isEmpty()) {
			this.setViewPage("../boardList.do");
			this.setRedirect(true);
			return;
		}
		int num=Integer.parseInt(numStr);
		BoardDAO dao=new BoardDAO();
		//3_1. 해당 글 내용 가져오기
		BoardVO vo=dao.viewBoard(num);
		//3_2. 첨부파일이 있다면 서버 upload디렉토리에서 해당 파일 삭제
		if(vo!=null&&vo.getFilename()!=null) {
			//upload디렉토리의 절대경로 얻기 + 첨부파일명
			ServletContext app=req.getServletContext();
			String upDir=app.getRealPath("/upload");
			File delFile=new File(upDir, vo.getFilename());
			if(delFile!=null) {
				boolean isDel=delFile.delete();
				System.out.println("첨부파일 삭제 여부: "+isDel);
			}
		}
		//3_3. dao의 deleteBoard(글번호)
		int n=dao.deleteBoard(num);
		
		String str=(n>0)? "글 삭제 성공":"글 삭제 실패";
		String loc=(n>0)? "../boardList.do":"javascript:history.back()";
		
		//4. 그 결과 메시지, 이동경로 처리
		req.setAttribute("msg", str);
		req.setAttribute("loc", loc);
		
		this.setViewPage("/message.jsp");
		this.setRedirect(false);

	}

}
