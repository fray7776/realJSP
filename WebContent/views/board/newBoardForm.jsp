<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WRITE NEW BOARD</title>
</head>
<body>
	<div align="center">
		<div><h1>NEW WRITE BOARD</h1></div>
		<form id="frm" name="frm" action="WriteNewBoard.do" method="post">
		<table border="1">
			<tr>
				<th>NAME</th>
				<td><input type="text" id="bName" name="bName"></td>
				<th>DATE</th>
				<td><input type="date" id="bDate" name="bDate"></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td colspan="3"><input type="text" id="bTitle" name="bTitle"></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td colspan="3"><textarea id="bContent" name="bContent" rows="25" cols="50"></textarea></td>
			</tr>
		</table>
	<input type="submit" id="save" name="save" value="SAVE">&nbsp;&nbsp;&nbsp;
	<input type="reset" id="cancle" name="cancle" value="CANCLE">
	
	</form>
	
	</div>
</body>
</html>