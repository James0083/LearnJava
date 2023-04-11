<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, memo.app.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<link rel="stylesheet" type="text/css" href="css/memo.css">
</head>
<body>
<div id="wrap">
	<%
		//request: 내장객체 (HttpServletRequest타입)
		List<MemoVO> arr = (List<MemoVO>)request.getAttribute("memoArr");
		//out : 내장객체 (JspWriter타입)
	//	out.println("arr="+arr+"<br>");
	%>

	<table border="1">
		<tr>
			<th colspan="4">
				<h2>:: 한줄 메모장 목록 ::</h2>
			</th>
		</tr>
		<tr>
			<td width="10%"><b>글번호</b></td>
			<td width="60%"><b>메모내용</b></td>
			<td width="20%"><b>작성자</b></td>
			<td width="10%"><b>수정 | 삭제</b></td>
		</tr>
		
		<%
		if(arr!=null){
			for(MemoVO vo:arr){
		%>
		<tr>
			<td><%=vo.getNo() %></td>
			<td><%=vo.getMsg() %><span class="wdate">[<%=vo.getWdate()%>]</span></td>
			<td><%=vo.getName() %></td>
			<td>
				<a href="MemoEditForm?no=<%=vo.getNo()%>">수정</a> | 
				<a href="MemoDelete?no=<%=vo.getNo()%>">삭제</a>
			</td>
		</tr>	
		<%
			}//for--------
		}//if------------
		
		%>	
	</table>
</div>
</body>
</html>