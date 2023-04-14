<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*, java.util.*"%>

<jsp:include page="/top.jsp"/>

    <div class="container">
    	<h1>회원 목록 페이지 [Admin Page]</h1>
    	<table id="userTable" border="1">
    		<tr>
    			<th class="m3" >번호</th>
    			<th class="m3" >이름</th>
    			<th class="m3" >아이디</th>
    			<th class="m3" >연락처</th>
    			<th class="m3" >회원상태</th>
    			<th class="m3" >수정|삭제</th>
    		</tr>
    		<!-- ------------------- -->
    		<%
    			UserDAO userDao=new UserDAO();
    			List<UserVO> arr = userDao.listUser();
    			if(arr==null||arr.size()==0){
    				out.println("<tr><td colspan='6'>데이터가 없습니다</td></tr>");
    			}else{
    				for(UserVO vo:arr){
    		%>
			    		<tr>
			    			<td><%=vo.getIdx() %></td>
			    			<td><%=vo.getName() %></td>
			    			<td><%=vo.getUserid() %></td>
			    			<td><%=vo.getAllHp() %></td>
			    			<td><%=vo.getMstate() %></td>
			    			<td>
			    			<a>수정</a>|
			    			<a>삭제</a>
			    			</td>
			    		</tr>
    		<%
    				}//for--------
    			}//else-----------------
    		%>
    		<!-- ------------------- -->
    	</table>
    </div>
<jsp:include page="/foot.jsp"/>