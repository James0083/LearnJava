<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<!-- 1. HTML 주석 -->
<h1>처음해보는 JSP</h1>
<%
//2. 자바주석 Script Element
//[1] scriptlet 테그: 이 안에서는 자바코드를 기술한다
/* 자바주석
	[2] expression(출력식)
*/
	Date today=new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String str = sdf.format(today);
	//out: 내장객체 JspWriter타입
	out.println("<h1>"+str+"</h1>");
	System.out.println(str);
%>
<h1 style='color:tomato'><%=str %></h1>
<%-- 3. JSP주석 

[1] scriptlet : <%  %> (스크립트렛): 자바코드 => 여기서 선언된 변수는 지역변수
[2] expression : <%= %> (출력식): 변수나 메서드의 반환값을 브라우저에 출력하고자 할때 사용
[3] declaration : <%! %> (선언문): 변수 선언하거나 사용자 정의 메서드를 이 안에서 구성한다. => 여기서 선언된 변수는 멤버변수가 된다
--%>
<%!
	String global="인스턴스 변수(멤버변수)";
	public String plus(int a, int b){
		
		return a+"+"+b+"="+(a+b);
	}
%>
<%
	String local = "지역변수";
%>
<h2>global: <%=global%> </h2>
<h2>local: <%=local%> </h2>
<%-- /Users/jaewonyou/myjava/WorkSpace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/work/Catalina/localhost/MyWeb/org/apache/jsp/example --%>
<h2><%=plus(45,75) %></h2>
<%
	out.println(plus(2, 3));
%>