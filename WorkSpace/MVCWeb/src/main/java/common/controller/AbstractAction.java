package common.controller;

abstract public class AbstractAction implements Action{
	
	//execute() 추상메서드를 가짐
	private String viewPage; //보여줄 뷰페이지 이름
	private boolean isRedirect; //true명 redirect이동, flase면 forward이동
	
	//setter, getter---------------
	public String getViewPage() {
		return viewPage;
	}
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

}///////////////////////////////
