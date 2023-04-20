<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String myctx=request.getContextPath();
%>
</article>
        <!-- aside : 사이드 영역, 사이드 메뉴가 들어감 -->
        <aside>
            <!-- aside -->
            <nav>
                <ul>
                    <li><a href="<%=myctx%>/example/ex07_error.jsp">에러처리</a></li>
                    <li><a href="<%=myctx%>/example/ex08_request.jsp">request1</a></li>
                    <li><a href="<%=myctx%>/example/ex09_request.jsp?keyword=Java&pageNum=1">request2</a></li>
                    <li><a href="<%=myctx%>/example/ex10_response.jsp">response</a></li>
                    <li><a href="<%=myctx%>/login/sessionTest.jsp">Session</a></li>
                    <li><a href="<%=myctx%>/login/cookieTest.jsp">Cookies</a></li>
                    <li><a href="<%=myctx%>/member/myPage.jsp">MyPage</a></li>
                </ul>
            </nav>
        </aside>

        <div class="cls"></div>
        <!-- footer : 푸터 영역, 회사 주소/연락처/copyright 등 -->
        <footer>
            <!-- footer -->
            Copyright|회사소개|연락처|주소|
        </footer>
    </div>  <!-- #wrap end -->
</body>
</html>