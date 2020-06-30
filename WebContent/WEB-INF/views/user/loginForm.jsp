<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	//String result = request.getParameter("result"); //(35)로그인했을때 result영역이 fail이라고 오는지 실험 userController로 가자
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/mysite2/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/mysite2/assets/css/user.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

		<c:import url ="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->
		
		<c:import url = "/WEB-INF/views/include/nav.jsp"></c:import>
		<!-- //nav -->

		<c:import url = "/WEB-INF/views/include/asideUser.jsp"></c:import>
		<!-- //aside -->

		<div id="content">
			
			<div id="content-head">
            	<h3>로그인</h3>
            	<div id="location">
            		<ul>
            			<li>홈</li>
            			<li>회원</li>
            			<li class="last">로그인</li>
            		</ul>
            	</div>
                <div class="clear"></div>
            </div>
             <!-- //content-head -->

			<div id="user">
				<div id="loginForm">
					<form action="/mysite2/user" method="get">

						<!-- 아이디 -->
						<div class="form-group">
							<label class="form-text" for="input-uid">아이디</label> 
							<input type="text" id="input-uid" name="id" value="" placeholder="아이디를 입력하세요">
						</div>

						<!-- 비밀번호 -->
						<div class="form-group">
							<label class="form-text" for="input-pass">비밀번호</label> 
							<input type="text" id="input-pass" name="password" value="" placeholder="비밀번호를 입력하세요"	>
						</div>
						
						<%//if("fail".equals(result)) {%>
						<p>
							<%//로그인에 실패했습니다. 다시 로그인해주세요.%> <%//(34) 파라미터 넣어주자 맨 위로 올라가 %>
						</p>
						
						<%//}%>
						
						<c:if test="${param.result eq 'fail' }">
						<p>
							로그인에 실패했습니다. 다시 로그인해주세요.
						</p>
						</c:if>
						
						
						
						<!-- 버튼영역 -->
		                <div class="button-area">
		                    <button type="submit" id="btn-submit">로그인</button>
		                </div>
		                
		                <input type="text" name="action" value = "login">
						
						
					</form>
				</div>
				<!-- //loginForm -->
			</div>
			<!-- //user -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>