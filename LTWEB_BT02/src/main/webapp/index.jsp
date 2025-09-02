<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chính</title>
</head>
<body>

	<%@ page session="true"%>
	<%
	String message = (String) session.getAttribute("message");
	if (message != null) {
	%>
	<h1><%=message%></h1>
	<%
	session.removeAttribute("message"); // Xóa sau khi hiển thị 1 lần
	}
	%>


</body>
</html>
