<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	String msg = (String)request.getAttribute("msg");
	String loc = (String)request.getAttribute("loc");
	
	el 표현식 : ${key값} 
--%>
<c:if test="${msg!=null && loc!=null}">
	<script>
	<%-- alert('<%=msg%>'); --%>
		alert('${requestScope.msg}');
		/*request에 저장된 msg 키값에 해당하는 value값을 출력하란 의미
		
			sessionScope.msg => 세션에 저장된 msg키에 해당하는 값
		*/
		<%-- location.href='<%=loc%>'; --%>
		location.href='${requestScope.loc}';
	</script>
</c:if>
<c:if test="${msg == null && loc!=null }">
	<script>
		location.href='${loc}';
	</script>
</c:if>