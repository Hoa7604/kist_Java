<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	//String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File</title>
</head>
<body>
	<h1> upload file </h1>
	<p>${message } -> EXpression Languge (EL)</p>
	<form action="${contextPath}/upload.do" method="post" enctype="multipart/form-data"> <!--send file-->
		File 1: <input type="file" name="file1"><br>
		File 2: <input type="file" name="file2"> <br>
		param 1: <input type="text" name="param1"><br>
		param 2: <input type="text" name="param2"> <br>
		<input type="submit" value="Upload Files">
	</form>
	<p><a href="${contextPath }/download.do?pho=puppy-01.jpg">[dowload image]</a></p>
</body>
</html>