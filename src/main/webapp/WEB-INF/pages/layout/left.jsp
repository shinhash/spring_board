<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<script src="${cp }/css/bootstrap.js"></script>

<link href="${cp }/css/bootstrap.css" rel="stylesheet"><!-- Bootstrap core CSS -->
<link href="${cp }/css/dashboard.css" rel="stylesheet">
<link href="${cp }/css/blog.css" rel="stylesheet">



	<div class="col-sm-3 col-md-2 sidebar">
		<ul class="nav nav-sidebar">
			<li class="active"><a href="${cp }/board/myboardView">MY BOARD</a></li>
			
			<c:forEach items="${bkList }" var="bk">
				<li class="active"><a href="${cp }/board/boardList?boardKindId=${bk.BOARD_KIND_ID }">${bk.BOARD_KIND_TITLE }</a></li>
			</c:forEach>
			
		</ul>
	</div>