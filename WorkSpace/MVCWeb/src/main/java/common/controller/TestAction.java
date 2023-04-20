package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//상속
//재정의
//req에 저장 msg, "From TestAction"
//hello.jsp로 forward이동하도록 설정
public class TestAction extends AbstractAction {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setAttribute("msg", "From TestAction");
		this.setViewPage("hello.jsp");
		this.setRedirect(false);
		
	}
}
