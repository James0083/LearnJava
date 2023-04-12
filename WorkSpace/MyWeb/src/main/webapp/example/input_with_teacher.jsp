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
<script type="text/javascript">
	function check(){
		if(!frm.empno.value){
			alert('사번을 입력하세요');
			frm.empno.focus();
			return false;
		}
		return true;
	}
</script>
<div id="wrap">
	<h1>성적 입력</h1>
	<form name="frm" action="result_with_teacher.jsp" method="post" onsubmit="return check()">
		<!-- table구성 -->
		<table border="1">
			<tr>
				<td colspan="2" width="40%">사번</td>
				<td>
					<input type="text" name="empno" id="empno"/>
				</td>
			</tr>
			<tr>
				<td rowspan="3" width="20%">과목</td>
				<td>Java</td>
				<td>
					<input type="text" name="java" id="java"/>
				</td>
			</tr>
			<tr>
				<td>Database</td>
				<td>
					<input type="text" name="db" id="db"/>
				</td>
			</tr>
			<tr>
				<td>JSP</td>
				<td>
					<input type="text" name="jsp" id="jsp"/>
				</td>
			</tr>
			<tr>
				<td colspan="3" style="text-align:center">
					<button>저 장</button>
				</td>
			</tr>
		</table>
	</form>
</div>