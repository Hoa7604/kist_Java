<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> Load File Example </title>
</head>
<body>
	<h1>Upload file</h1>
	<p> ${message} -> Expression langues }</p>
	<form action="${contextPath}/upload.do" method="post" enctype="multipart/form-data">
		File 1: <input type="file" name="file1"><br>
		File 2: <input type="file" name="file2"> <br>
		param 1: <input type="text" name="param1"><br>
		param 2: <input type="text" name="param2"> <br>
		<input type="submit" value="Upload Files">
	</form>
</body>
</html>