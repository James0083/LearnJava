<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	table td{
		text-align:center;
	}
</style>

<%
	int java = Integer.parseInt(request.getParameter("java"));
	int db = Integer.parseInt(request.getParameter("db"));
	int jsp = Integer.parseInt(request.getParameter("jsp"));
	double avg = (java+db+jsp)/3.0;
%>
<div id="wrap">
<h1>성적 처리 결과</h1>
<!-- table구성해서 처리 결과 보여주기 -->
<table border="1">
			<tr>
				<td colspan="2">
					사번
				</td>
				<td>
					<input type="text" name="no" value="<%=request.getParameter("no")%>" readonly />
				</td>
			</tr>
			<tr>
				<td rowspan="3">과목</td>
				<td>Java</td>
				<td>
					<input type="text" name="java" value="<%=java%>" readonly />
				</td>
			</tr>
			<tr>
				<td>Database</td>
				<td>
					<input type="text" name="database" value="<%=db%>" readonly />
				</td>
			</tr>
			<tr>
				<td>JSP</td>
				<td>
					<input type="text" name="jsp" value="<%=jsp%>" readonly />
				</td>
			</tr>
			<tr>
				<td colspan="2">평균</td>
				<td>
					<input type="text" name="avg" value="<%=avg%>" readonly />
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<button>입력화면</button>
				</td>
			</tr>
		</table>
</div>