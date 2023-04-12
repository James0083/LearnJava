<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	table td{
		text-align:center;
	}
</style>
<script type="text/javascript">
	function check(){
		if(mf.no.value==""){
			alert('사번을 입력하세요');
			mf.no.focus();
			return;
		}
		if(mf.java.value==""){
			mf.java.value=0;
		}
		if(mf.database.value==""){
			mf.database.value=0;
		}
		if(mf.jsp.value==""){
			mf.jsp.value=0;
		}
		mf.submit();
	}
</script>
<div id="wrap">
	<h1>성적 입력</h1>
	<form name="mf" action="result.jsp" method="GET">
		<!-- table구성 -->
		<table border="1">
			<tr>
				<td colspan="2">
					사번
				</td>
				<td>
					<input type="text" name="no"/>
				</td>
			</tr>
			<tr>
				<td rowspan="3">과목</td>
				<td>Java</td>
				<td>
					<input type="text" name="java" />
				</td>
			</tr>
			<tr>
				<td>Database</td>
				<td>
					<input type="text" name="db"/>
				</td>
			</tr>
			<tr>
				<td>JSP</td>
				<td>
					<input type="text" name="jsp"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<button onclick="check()">저장</button>
				</td>
			</tr>
		</table>
	</form>
</div>