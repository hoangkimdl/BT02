<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chờ xử lý</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">

    <div class="card shadow p-4">
        <h2 class="text-center mb-4">⏳ Đang chờ xử lý...</h2>

        <!-- Hiển thị thông tin người dùng -->
        <c:if test="${not empty sessionScope.account}">
            <p><strong>Tên đăng nhập:</strong> ${sessionScope.account.username}</p>
            <p><strong>Họ và tên:</strong> ${sessionScope.account.fullname}</p>
            <p><strong>Vai trò (roleId):</strong> ${sessionScope.account.roleId}</p>
        </c:if>

        <div class="text-center mt-4">
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">Đăng xuất</a>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
