<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


	
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			
<!-- 			접속을 안했을때 : 			==> [] -->
<!-- 			접속을 했을때 	: [brown] 	==> [brown] -->
			
			<c:choose>
				<c:when test="${MEMBER == null}">
					<a class="navbar-brand" href="${cp }/pages/main/main.jsp">MY BOARD</a>
				</c:when>
				<c:otherwise>
					<a class="navbar-brand" href="${cp }/pages/main/main.jsp">MY BOARD [ ${MEMBER.userid} ]</a>
				</c:otherwise>
			</c:choose>
			
			
			
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
				
				<c:choose>
					<c:when test="${MEMBER != null}">
						<li><a href="${cp }/logout">logOut</a></li>
					</c:when>
				</c:choose>
				
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>