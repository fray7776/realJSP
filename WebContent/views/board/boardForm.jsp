<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VIEW BOARD LIST</title>
<style type="text/css">
	tr.row:hover {
		background:lightyellow;
	}
</style>
<script type="text/javascript">
	function formSubmit(str) {
		frm.bId.value=str;
		frm.submit();
	}

</script>
</head>
<body>
<div align="center"><h1>VIEW BOARD</h1></div>
 <div>
	<form id="frm" name="frm" action="boardView.do" method="post">
		<input type="hidden" id="bId" name="bId">
	</form>
</div> 
<div align="center">
		<table border = "1">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>TITLE</th>
				<th>CONTENT</th>
				<th>DATE</th>
				<th>HIT</th>
				
			</tr>
			<c:choose>
			<c:when test="${empty list }">
				<tr><td colspan="5">NO LIST</td></tr>
			</c:when>
			<c:when test="${not empty list }">
				<c:forEach var="vo" items="${list }">
				<tr class="row" onclick="formSubmit(${vo.bId })">
				<td align="center">${vo.bId }</td>
				<td align="center">${vo.bName }</td>
				<td align="center">${vo.bTitle }</td>
				<td align="center">${vo.bContent }</td>
				<td align="center">${vo.bDate }</td>
				<td align="center">${vo.bHit }</td>
				</tr>
				</c:forEach>
				</c:when>
			</c:choose>
		</table>
</div>
<div align="center">
<button type="button" onclick="location.href='newBoard.do'">WRITE NEW BOARD</button>
</div>

</body>
</html>