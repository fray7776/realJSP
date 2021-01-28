<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOW CONTENT </title>
<script type="text/javascript">
 function deleteAlert(){
	 var yn = confirm('Do you really want to delete?');
	 	if(yn) {
	 		frm.action.value="boardDelete.do";
	 		frm.submit();
	 	}else{
	 		
	 	}
 }
 function updateAlert(){
	 var yn= confirm('Do you really want to update?');
	 	if(yn) {
	 		frm.action.value="boardEdit.do";
	 		frm.submit();
	 	}else{
	 		
	 	}
 }

</script>
</head>
<body>
<div align="center">
	
	<div>
	<table border="1">
	
			<tr>
				<th width="100">NAME</th>
				<td width="120">${vo.bName }</td>
				<th width="100">DATE</th>
				<td width="120">${vo.bDate }</td>
				<th width="100">HIT NO</th>
				<td width="100">${vo.bHit }</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td colspan="5">${vo.bTitle }</td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td colspan="5"><textarea rows="25" cols="90">${vo.bContent }</textarea></td>
			</tr>
		</table>
		</div><br/>
		
	<div>
		<button type="button" onclick="location.href='selectList.do'">GOBACK</button>&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="updateAlert(${bId})">UPDATE</button>&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="deleteAlert(${bId})">DELETE</button>
	</div>
	<form id="frm" name="frm" method="post">
		<input type="hidden" id="bId" name="bId" value="${vo.bId }">
	</form>
	</div>	

	

</body>
</html>