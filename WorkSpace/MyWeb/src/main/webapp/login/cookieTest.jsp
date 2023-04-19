<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.text.*"%>

<jsp:include page="/top.jsp"/>

    <div class="container">
    	<h1>쿠키 저장하기</h1>
    	<br>
    	<%
    	//[1] 쿠키 생성 단계 (key, value)
    	// 쿠키에 저장할 key,value 값에는 특수문자,한글,공백,-,;,콤마(,) 등은 저장할 수 없다.
    	// 언더바(_), 콜론(:) 은 사용 가
    		Cookie ck1=new Cookie("visited", "james");
    		
    		Date d=new Date();
    		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_hh:mm:ss");
    		String visitTime=sdf.format(d);
    		
    		Cookie ck2=new Cookie("visiteTime", visitTime);
    		
    	//[2] 쿠키 속성 설정 단계(유효시간 expiry, 도메인 domain, 경로 path, ...)
    		ck1.setMaxAge(60*60*24*3);//3일간 유효
    		ck2.setMaxAge(60*60*24*7);//7일간 유효
    		//setMaxAge()로 유효시간 설정. 0값을 주면 쿠키는 삭제된다
    		
    		ck1.setPath("/");//setDomain()...
    	//[3] 쿠키 전송단계
    		response.addCookie(ck1);
    		response.addCookie(ck2);
    		
    	%>
    	<h2><a href="cookieList.jsp">쿠키 목록 보러가기</a></h2>
    </div>
<jsp:include page="/foot.jsp"/>