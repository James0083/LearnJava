<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	table{
		width:50%;
		margin:auto;
		height:300px;
		border-collapse:collapse;
	}
	h1,td{
		text-align:center;
	}
	table td:last-child{
		text-align:left;
		padding-left:2em;
	}
	input{
		padding: 5px;
	}
</style>

<%
	//1. 입력값 받아오기
	String empno=request.getParameter("empno");
	String java_str=request.getParameter("java");
	String db_str=request.getParameter("db");
	String jsp_str=request.getParameter("jsp");
	
	//2. 유효성 체크
	if(empno==null||"".equals(empno.trim())){
		response.sendRedirect("input_with_teacher.jsp");
		return;
	}
	if(java_str==null||java_str.trim().isEmpty()){
		java_str="0";
	}
	if(db_str==null||db_str.trim().isEmpty()){
		db_str="0";
	}
	if(jsp_str==null||jsp_str.trim().isEmpty()){
		jsp_str="0";
	}
	int sum = Integer.parseInt(java_str.trim())+Integer.parseInt(db_str.trim())+Integer.parseInt(jsp_str.trim());
	int avg = sum/3;
%>
<div id="wrap">
<h1>성적 처리 결과</h1>
<!-- table구성해서 처리 결과 보여주기 -->
<table border="1">
			<tr>
				<td colspan="2" width="40%">사번</td>
				<td>
					<%=empno %>
				</td>
			</tr>
			<tr>
				<td rowspan="3" width="20%">과목</td>
				<td>Java</td>
				<td>
					<%=java_str %>
				</td>
			</tr>
			<tr>
				<td>Database</td>
				<td>
					<%=db_str %>
				</td>
			</tr>
			<tr>
				<td>JSP</td>
				<td>
					<%=jsp_str %>
				</td>
			</tr>
			<tr>
				<td colspan="2">평균점수</td>
				<td>
					<%=avg %>점
				</td>
			</tr>
			<tr>
				<td colspan="3" style="text-align:center">
					<button onclick="location.href='input_with_teacher.jsp'">입력화면</button>
				</td>
			</tr>
		</table>
</div>