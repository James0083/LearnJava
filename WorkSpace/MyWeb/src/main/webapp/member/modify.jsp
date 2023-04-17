<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp"/>
<!-- ----------------------------------------- -->
<script type="text/javascript" src="../js/userCheck.js"></script>
<!-- ----------------------------------------- -->
<!-- 
[1] 회원번호 파라미터값 받기
[2] 유효성 체크 - list.jsp로 redirect이동
[3] userDao id로 UserDAO빈 생성
   	=> useBean액션 사용하기
[4] userDao 의 selectUserByIdx()메서드 호출하기
[5] 그 결과 값을 html input의 value값으로 출력해주자
 -->
<jsp:useBean id="userDao" class="user.model.UserDAO" scope="session"/>
<jsp:useBean id="user" class="user.model.UserVO" scope="page"/>
<%
	String idxStr = request.getParameter("idx");
	if(idxStr==null||idxStr.trim().isEmpty()){
		response.sendRedirect("list.jsp");
	}
	out.println(idxStr);
	int idx = Integer.parseInt(idxStr);
	user = userDao.selectUserByIdx(idx);
	
%>
<div class="container">
	<h1>회원 가입</h1>
	<form name="mf" action="modifyEnd.jsp" method="post">
	<table id="userTable" border="1">
		<tr>
			<td width="20%" class="m1"><b>회원번호</b></td>
			<td width="80%" class="m2">
			<input type="text" name="idx" id="idx" placeholder="Idx" readonly value="<%=user.getIdx() %>">
			<br>
			</td>
		</tr>
		<tr>
			<td width="20%" class="m1"><b>이  름</b></td>
			<td width="80%" class="m2">
			<input type="text" name="name" id="name" placeholder="Name">
			<br>
			<span class="ck">*이름은 한글만 가능해요</span>
			</td>
		</tr>
		<tr>
			<td width="20%" class="m1"><b>아이디</b></td>
			<td width="80%" class="m2">
			<input type="text" name="userid" id="userid" placeholder="User ID">
			<button type="button" onclick="open_idcheck()">아이디 중복 체크</button>
			<br>
			<span class="ck">*아이디는 영문자, 숫자, _, !만 사용 가능해요</span>
			</td>
		</tr>
		<tr>
			<td width="20%" class="m1"><b>비밀번호</b></td>
			<td width="80%" class="m2">
			<input type="password" name="pwd" id="pwd" placeholder="Password">
			<br>
			<span class="ck">*비밀전호는 문자, 숫자, !, .포함해서 4~8자리 이내</span>
			</td>
		</tr>
		<tr>
			<td width="20%" class="m1"><b>비밀번호 확인</b></td>
			<td width="80%" class="m2">
			<input type="password" name="pwd2" id="pwd2" placeholder="Re Password">
			<br>
			</td>
		</tr>
		<tr>
			<td width="20%" class="m1"><b>연락처</b></td>
			<td width="80%" class="m2">
			<input type="text" name="hp1" id="hp1" placeholder="HP1" maxlength="3">-
			<input type="text" name="hp2" id="hp2" placeholder="HP2" maxlength="4">-
			<input type="text" name="hp3" id="hp3" placeholder="HP3" maxlength="4">
			<br>
			<span class="ck">*앞자리(010|011)중에 하나-(숫자3~4자리)-(숫자4자리)만 가능해요</span>
			</td>
		</tr>
		<tr>
			<td width="20%" class="m1"><b>우편번호</b></td>
			<td width="80%" class="m2">
			<input type="text" name="post" id="post" placeholder="Post" maxlength="5">
			<button type="button" onclick="">우편번호 찾기</button>
			<br>
			</td>
		</tr>
		<tr>
			<td width="20%" class="m1"><b>주   소</b></td>
			<td width="80%" class="m2">
			<input type="text" name="addr1" id="addr1" placeholder="Address1" style="margin-bottom:5px;">
			<br>
			<input type="text" name="addr2" id="addr2" placeholder="Address2">
			</td>
		</tr>
		<tr>
			<td width="20%" class="m1"><b>마일리지</b></td>
			<td width="80%" class="m2">
			<input type="text" name="mileage" id="mileage" placeholder="Mileage">
			</td>
		</tr>
		<tr>
			<td width="20%" class="m1"><b>회원상태</b></td>
			<td width="80%" class="m2">
			<span class='mstate'>
			회원상태정보
			</span><br>
			<input type="radio" name="mstate" value="0" class='radio_btn'>활동 회원
			<input type="radio" name="mstate" value="-1" class='radio_btn'>정지 회원
			<input type="radio" name="mstate" value="-2" class='radio_btn'>탈퇴 회원
			<br>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="m2" style="text-align:center">
				<button type="button" onclick="member_check()">수정하기</button>
				<button type="reset">다시쓰기</button>
			</td>
		</tr>
	</table>
	</form>
</div>
<jsp:include page="/foot.jsp"/>

