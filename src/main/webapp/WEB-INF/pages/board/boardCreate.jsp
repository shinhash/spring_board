<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Board Craete</title>
	
	
	 <%@ include file="/WEB-INF/pages/linkInfo/link_tag_Info.jsp" %>


	<script type="text/javascript">
	
		$(document).ready(function(){
			
			$("#addBoard").on("click", function(){

				var boardKindTitle = $("#addboardName").val()
				if(boardKindTitle == "" || boardKindTitle == " "){
					alert("게시판의 이름을 작성해주세요.")
				}else{
					$("#addForm").submit();
				}
				
				
			})

			$(".upBKSt").on("click", function(){

				
				
				var bkId = $(this).val()
				var use = $(this).parents(".updateDiv").find(".useSelect").val()
				var before = $(this).parents(".updateDiv").find(".boardKindStatus").val()
				
				if(use == before){
					alert("변경하지 않았습니다.")
				}else{

					alert("변경하였습니다.")
					
					$("#upBoardKindId").val(bkId)
					$("#boardUse").val(use)
					
					$("#UpdateBKForm").submit();
				}
			})
			
			
		})
	</script>


</head>

<body>


			<div class="col-sm-8">
			
				<br>
				<br>
				<br>

				<form id="addForm" action="${cp }/board/boardCreate" method="post">
					게시판 이름 : <input type="text" id="addboardName" name="addboardName" /> 
					<select name="board_use">
						<option value="Y">사용</option>
						<option value="N">미사용</option>
					</select>
					<button type="button" id="addBoard">생성</button>
				</form>
				<br>
				
				
				
				<!-- 회원이 생성한 게시판 정보 -->
				<form action="${cp }/board/boardKindUpdate" method="post" id="UpdateBKForm">
					<c:forEach items="${memBkList }" var="memBk">
						<div class="updateDiv">
						
							<c:set var="bkStatus" value="${memBk.BOARD_KIND_STATUS}"></c:set>
							
							게시판 이름 : <input type="text" name="updateBoardInfo" value="${memBk.BOARD_KIND_TITLE }" readonly="readonly"/> 
							
							<select class="useSelect" name="board_use">
								<c:choose>
								
									<c:when test="${bkStatus eq 'Y'}">
										<option value="Y" selected="selected">사용</option>
										<option value="N">미사용</option>									
									</c:when>
									
									<c:when test="${bkStatus eq 'N'}">
										<option value="Y">사용</option>
										<option value="N" selected="selected">미사용</option>	
									</c:when>
									
								</c:choose>
								
							</select>
							<button type="button" class="upBKSt" name="upBKID" value="${memBk.BOARD_KIND_ID }">수정</button>
							<input type="hidden" class="boardKindStatus" value="${bkStatus }" />
							<br>
						</div>
						
					</c:forEach>
					
					<input id="upBoardKindId" type="hidden" name="upBoardKindId" />
					<input id="boardUse" type="hidden" name="boardUse" />
				</form>
				<!------------------------>
				
				
				
				
				
				
			</div>
</body>
</html>