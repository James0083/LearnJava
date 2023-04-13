<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/top.jsp"/>

    <div style="padding:2em" class="container">
    	<h1>request - form</h1>
    	<form name="frm" id="frm" action="ex08_requestResult.jsp" method="get">
	        이 름 : <input type="text" name="userName" placeholder="이름을 입력하세요"><br>
	        아이디 : <input type="text" name="userid"><br>
	        비밀번호 : <input type="password" name="userPwd" placeholder="Password"><br>
	        사진 : <input type="file" name="photo"><br>
	        
	        성별 : <input type="radio" name="gender" value="M">남자 
	            <input type="radio" name="gender" value="F">여자
	            <br>
	        <!-- 단일선택 : radio 버튼 (name이 같은 버튼 중 하나만 선택가능)
	            다중선택 : checkbox 버튼
	        -->
	        취미:
	        <input type="checkbox" name="hobby" value="sports">운동
	        <input type="checkbox" name="hobby" value="Reading" checked>독서
	        <input type="checkbox" name="hobby" value="Music">음악감상
	        <input type="checkbox" name="hobby" value="Movie">영화감상
	        <br>
	        <!-- 
	            select : (default)단일 선택
	                - multiple 속성으로 다중선택이 가능하다
	                - size 속성으로 펼친형태 조절가능
	         -->
	        드롭다운 리스트:
	        <select name="job" id="job">
	            <option value="">::직업을 선택하세요::</option>
	            <option value="Developer">개발자</option>
	            <option value="Designer">디자이너</option>
	            <option value="Teacher">교사</option>
	        </select>
	        <br>
	        <select name="lang" id="lang" multiple size="7">
	            <option value="">::사용가능 언어::</option>
	            <option value="HTML">HTML</option>
	            <option value="Java">Java</option>
	            <option value="SQL">SQL</option>
	            <option value="JavaScript">JavaScript</option>
	        </select>
	        <br>
	        <textarea name="intro" id="intro" cols="70" rows="5" placeholder="자기소개를 100자 이내로 작성하세요"></textarea>
	        <br>
	        히든 필드:
	        <input type="hidden" name="secret" value="TopSecret">
	        <br>
	        <!-- submit버튼 : 서버로 데이터를 전송하는 버튼 
	             reset버튼 : 초기화 기능
	             button버튼 : 아무기능 없음 => javascript와 함께 사용하여 기능 부여
	        -->
	        <input type="submit" value="회원가입">
	        <input type="reset" value="다시쓰기">
	        <input type="button" value="일반버튼" onclick="alert('안녕하세요?')">
	        <!-- 이미지 버튼 -->
	        <a onclick="alert('로그인!')"><img src="images/login.png"></a>
	
	        <!-- input type="image" ==> submit기능을 갖는다 -->
	        <input type="image" src="images/login.png">
	    </form>
    </div>
<jsp:include page="/foot.jsp"/>