<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/top.jsp"/>

    <div class="container">
    	<h1>사용자가 입력한 값 받기</h1>
    	<%
    		//단일값 받기: String getParameter("파라미터명")
    		//다중값 받기: String[] getParameterValues("파라미터명")
    		//request : HttpServletRequest타입
    		String name=request.getParameter("userName");
    		String uid=request.getParameter("userid");
    		String gender=request.getParameter("gender");
    		String job=request.getParameter("job");
    		String photo=request.getParameter("photo");
    		
    		String[] hobbies = request.getParameterValues("hobby");
    		String[] langs = request.getParameterValues("lang");
    	%>
    	<hr color='red'>
    	<ul>
    		<li>이름: <%=name %></li>
    		<li>아이디: <%=uid %></li>
    		<li>성별: <%=gender %></li>
    		<li>첨부파일명: <%=photo %></li>
    		<li>직업: <%=job %></li>
    		
    		<li>취미: 
    		<%
    		if(hobbies!=null){
    			for(String hobby:hobbies){
    				out.println(hobby+", ");
    			}//for---
    		}//if----------
    		%>
    		</li>
    		
    		<li>사용 언어: 
    		<%
    		if(langs!=null){
    			for(String lang:langs){
    				out.println(lang+",");
    			}
    		}
    		%>
    		</li>
    	</ul>
    </div>
<jsp:include page="/foot.jsp"/>yjsp