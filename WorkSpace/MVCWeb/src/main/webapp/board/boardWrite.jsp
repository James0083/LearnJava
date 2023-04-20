<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/top.jsp"/>
<style>
	ul li{
		list-style-type:none;
	}
	#bbs{
		width:80%;
		margin:1.5em auto;
		
	}
	#boardF li{
		padding:8px 5px;
		text-align:left;
	}
	#subject, #content, #filename{
		width:90%;
	}
	#boardF input,textarea{
		padding:5px;
	}
	#boardF li:last-child{
		text-align:center;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	const board_check=function(){
		if(!$('#subject').val()){
			alert('제목을 입력하세요');
			$('subject').focus();
			return false;
		}
		if(!$('#content').val()){
			alert('글내용을 입력하세요');
			$('#content').focus();
			return false;
		}
		
		return true;
	}
</script>
    <div class="container m2">
    	<h1>Board 글쓰기</h1>
    	<div id="bbs">
    		<form name="boardF" id="boardF" action="boardWrite.do" method="post" onsubmit="return board_check()">
				<ul>
					<li>제  목</li>
					<li>
						<input type="text" name="subject" id="subject" placeholder="Subject">
					</li>
					<li>글내용</li>
					<li>
						<textarea name="content" id="content" placeholder="Content"
						rows="10" cols="50"></textarea>
					<li>첨부파일</li>
					<li>
						<input type="file" name="filename" id="filename" placeholder="Attach File">
					</li>
					<li>
						<button>글쓰기</button>
						<button type="reset">다시쓰기</button>
					</li>
				</ul>    		
    		</form>
    	</div>
    </div>
<jsp:include page="/foot.jsp"/>