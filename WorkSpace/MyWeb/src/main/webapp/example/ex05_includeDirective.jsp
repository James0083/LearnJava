<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>include 지시어에 대해 살펴봅시다</h1>

<h2>현재 페이지는 ex05_includeDirective.jsp 페이지입니다. </h2>
<h3>include지시어는 특정 페이지를 포함시키고자 할 때 사용합니다.</h3>
<h3>include지시어를 이용하면 포함시킬 페이지의 소스 코드를 삽입하는 형태로 포함시킵니다.</h3>
<hr color='red'>

<%@ include file="ex03.jsp" %>
<%-- 
//정리//
예를 들어 include한 파일 안에 있는 변수 등을 사용해야 하는 경우에는 include지시어를 이용해서 소스코드를 삽입해야하는 것이고,
그럴 필요가 없는 경우에는 굳이 소스코드를 포함시킬 필요가 없으므로 include액션을 이용해서 페이지를 가볍게 만들 수 있다. 
--%>  