<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/top.jsp"/>
<style>
	div.container *{
		margin: 8px;
	}
</style>
    <div class="container">
    	<h1>response객체 - HttpServletResponse타입</h1>
    	<form name="f" action="ex10_responseResult.jsp" method="post">
    		<div style="width:60%; height:20vh; margin:auto;">
    			<p>
    				아이디: <input type="text" name="userid">
    			</p>
    			<p>
    				비밀번호: <input type="password" name="pwd">
    			</p>
    			<button>Login</button>
    		</div>
    	</form>
    </div>
<jsp:include page="/foot.jsp"/>