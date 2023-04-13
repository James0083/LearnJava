<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/top.jsp"/>

    <div class="container">
    	<h1>request의 주요 메서드</h1>
    	<%
    		String server = request.getServerName();//서버 도메인명
    		int port=request.getServerPort(); //서버에서 열어둔 포트번호
    		StringBuffer buf=request.getRequestURL(); //전체 URL을 반환
    		String url=buf.toString();
    		//http://localhost:7070/MyWeb/example/ex09_request.jsp
    		String uri=request.getRequestURI();
    		//uri => 컨텍스트명 이후 경로를 반환
    		//Myweb/example/ex09_request.jsp
    		String ctx=request.getContextPath(); // "/MyWeb"
    		String qStr=request.getQueryString(); // query string 반환
    		String clientIP=request.getRemoteAddr(); // client ip주소를 반환
    		
    		//[실습1]: uri문자열에서 "/example/ex09_request.jsp" 문자열을 추출해서 출력하세요
        	String exp1=uri.replace(ctx, "");
        	//[실습2]: uri문자열에서 "/example/ex09_request" 문자열을 추출해서 출력하세요
    		String exp2=exp1.replace(".jsp","");
        	
        	/* 
        	if(exp2.equals("example/ex01")){
        		//ex01.jsp로 페이지 이동
        	} */
        	
        	String path=request.getServletPath(); //컨텍스트명을 포함하지 않는 경로 문자열을 반환
        	//"/example/ex09_request.jsp"
        	String proto=request.getProtocol();
        	
        	int index=path.lastIndexOf(".jsp");
        	System.out.println(index);
        	if(index>0){
        		//path=path.substring(0,index);
        	}
    	%>
    	<h2>서버 도메인명: <%=server %></h2>
    	<h2>서버 포트번호: <%=port %></h2>
    	<h2>요청 URL	: <%=url %></h2>
    	<h2>요청 URI	: <%=uri %></h2>
    	<h2>컨텍스트명	: <%=ctx %></h2>
    	<h2>쿼리 스트링	: <%=qStr %></h2>
    	<h2>클라이런트 IP	: <%=clientIP %></h2>
    	<h2>프로토콜	: <%=proto %></h2>
    	<h2>서블릿 패스	: <%=path %></h2>
    	<h2><%=exp1 %></h2>
    	<h2><%=exp2 %></h2>
    </div>
<jsp:include page="/foot.jsp"/>