<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>include 액션을 이용해서 ex03.jsp페이지를 포함시켜 봅시다</h1>
<h2>include 액션은 소스를 포함시키는 방식이 아니라, 실행결과를 포함시키는 방식이다</h2>
<h3>JSP흐름을 ex03.jsp로 이동시켜 그 실행 결과를 현재 위치에 포함시킨다</h3>
<hr color='blue'>

<%-- <jsp:include page="ex03.jsp"></jsp:include> --%>  <%-- 시작태그와 닫는 태그 사이에 공백이 있으면 안된다. --%>
<jsp:include page="ex03.jsp"/>
<br><br/>
<%--
액션 요소 (Action Element)
 <jsp:include page="포함시킬페이지"/>
--%>

<%--
	RequestDispatcher disp=request.getRequestDispatcher("ex03.jsp");
	disp.include(request, response);
	과 jsp include 액션은 동일한 코드다.

--%>