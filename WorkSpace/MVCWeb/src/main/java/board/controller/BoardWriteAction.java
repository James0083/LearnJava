package board.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

public class BoardWriteAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//1. post방식 한글처리==>필터를 만들어서 처리
//		req.setCharacterEncoding("utf-8");
		//2. 파일 업로드 처리 ==> 라이브러리 다운로드 후
		//업로드할 디렉토리 절대경로 얻기:
		ServletContext app=req.getServletContext();
		String upDir=app.getRealPath("/upload");
		System.out.println(upDir);
		
		File dir=new File(upDir);
		if(!dir.exists()) {
			dir.mkdirs(); //디렉토리 생성
		}
		DefaultFileRenamePolicy df=new DefaultFileRenamePolicy();
		MultipartRequest mr=new MultipartRequest(req, upDir, 100*1024*1024, "utf-8", df);
		System.out.println("업로드 성공!!");
		
		
		//3. 사용자가 입력한 값 받기
		String userid="hong"; //세션에서 로그인한 사용자 아이디
		String subject=mr.getParameter("subject");
		String content=mr.getParameter("content");
		//String filename=mr.getParameter("filename");	//[X]
		String filename=mr.getFilesystemName("filename");	//[O]
		
		long filesize=0;
		File f=mr.getFile("filename");
		if(f!=null) {
			filesize=f.length();
		}
		//4. 유효성 체크
		if(userid==null||subject==null||content==null||subject.trim().isEmpty()) {
			this.setViewPage("boardForm.do");
			this.setRedirect(true);
			return;
		}
		
		//5. BoardVO에 담기
		BoardVO board=new BoardVO(0,userid,subject,content,null,0,filename,filesize);
		
		//6. BoardVO의 insertBoard()
		BoardDAO dao=new BoardDAO();
		int n=dao.insertBoard(board);
		
		//7. 그 결과 메시지, 이동경로 처리
		String str=(n>0)?"글쓰기 성공":"글쓰기 실패";
		String loc=(n>0)?"../boardList.do":"javascript:history.back()";

		
		req.setAttribute("msg", str);
		req.setAttribute("loc", loc);
		this.setViewPage("/message.jsp");
		this.setRedirect(false);

	}

}
