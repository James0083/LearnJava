<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*" errorPage="/login/errorAlert.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	String uid=request.getParameter("userid");
	String pwd=request.getParameter("pwd");
	
	if(uid==null||pwd==null||uid.trim().isEmpty()||pwd.trim().isEmpty()){
		response.sendRedirect("login.jsp");
		return;
	}
	//UserDAO빈 생성해서 UserVO loginCheck(uid, pwd)
	/*
		1) 아이디와 비번이 일치하는지 db에서 확인해서 일치하면 해당 회원정보를 UserVO에 담아서
			반환해줌
		2) 일치하지 않으면 사용자정의 예외(NotUserException)를 발생시킨다.
	*/
%>
<jsp:useBean id="userDao" class="user.model.UserDAO" scope="session"/>
<%
	UserVO loginUser=userDao.loginCheck(uid, pwd);
	if(loginUser!=null){
		//out.println(loginUser.getName()+"님 환영합니다");
		//로그인 성공을 했다면 로그인한 사람 정보를 세션 저장하자 ==> "xxx님 로그인중..."
		//session 내장객체: HttpSession타입
		//HttpSession <= request.getSession()
		session.setAttribute("loginUser", loginUser);
		
		response.sendRedirect("../main.jsp");
	}
%>