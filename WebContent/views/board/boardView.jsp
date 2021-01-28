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
	 		location.href="boardDelete.do";
	 	}else{
	 		
	 	}
 }
 function updateAlert(){
	 var yn= confirm('Do you really want to update?');
	 	if(yn) {
	 		location.href="boardUpdate.do";
	 	}else{
	 		
	 	}
 }

</script>
</head>
<body>
<div align="center">
	<table border="1">
	
			<tr>
				<th width="100">NAME</th>
				<td width="120">${vo.bId }</td>
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
	<button type="button" onclick="location.href='selectList.do'">GOBACK</button>&nbsp;&nbsp;&nbsp;
	<button type="button" onclick="updateAlert()">UPDATE</button>&nbsp;&nbsp;&nbsp;
	<button type="button" onclick="deleteAlert()">DELETE</button>&nbsp;&nbsp;&nbsp;
</div>	
</body>
</html>