<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/layout.css">
<script type="text/javascript" src="../js/userCheck.js"></script>
<%
	//요청방식
	String method=request.getMethod();
	out.println(method+"<br>");
	//GET방식일 때는 아이디 입력 폼을 보여주고
	//POST방식일 때는 아이디 사용 가능 여부 결과를 보여주자
	if(method.equalsIgnoreCase("get")){
%>
<div class="container m2" style="margin-top:2em">
	<form name="idf" action="idCheck.jsp" method="post">
		<label for="userid">아이디</label>
		<input type="text" name="userid" id="userid" placeholder="User ID" autofocus="autofocus">
		<button type="button" onclick="id_check()">확  인	</button>
	</form>
</div>
<% }else{ 
	//post방식일 때 - 사용자가 입력한 아이디값 받기
	String userid = request.getParameter("userid");
%>
<jsp:useBean id="userDao" class="user.model.UserDAO" scope="session"/>
<% 
	boolean isUse=userDao.idCheck(userid);
	if(isUse){
%>
<div class="container m2" style="margin-tip:2em">
	<h3>ID로 [<span class="ck"><%=userid %></span>]을 사용할 수 있습니다</h3>
	<br>
	<button onclick="set_id('<%=userid%>')">닫  기</button>
</div>
<% 
	}else{
%>
<div class="container m2" style="margin-tip:2em">
	<h3>ID로 [<span class="ck"><%=userid %></span>]을은 이미 사용중 입니다</h3>
	<br>
	
	<form name="idf" action="idCheck.jsp" method="post">
		<label for="userid">아이디</label>
		<input type="text" name="userid" id="userid" placeholder="User ID" autofocus="autofocus">
		<button type="button" onclick="id_check()">확  인	</button>
	</form>
</div>
<%
	}//else-------
}//else----------------- %>