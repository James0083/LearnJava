<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/top.jsp"/>

    <div class="container m2">
    	<h1>파일 업로드 테스트</h1>
    	<br><br>
    	<!-- 
    	파일 업로드 주의사항
    	[1] method: post여야 함
    	[2] post방식일 경우 인코딩방식(enctype)이 2가지가 있는데
    		(1) application/x-www-form-urlencoded (디폴트)
    			==> 이 경우는 첨부파일명만 서버에 전송된다
    		(2) multipart/form-data
    			==> 파일 이름과 함께 파일 데이터가 서버에 전송된다
    	 -->
    	<form name="f" id="f" method="post" enctype="multipart/form-data" action="uploadEnd.do">
    		<label>올 린 이:</label>
    		<input type="text" name="writer"><br><br>
    		<label>첨부 파일:</label>
    		<input type="file" name="fname"><br><br>
    		<button>Uplead</button>
    	</form>
    </div>
<jsp:include page="/foot.jsp"/>