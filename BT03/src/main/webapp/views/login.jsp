<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" 
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body class="container mt-5">
    <form action="${pageContext.request.contextPath}/login" method="post"
          class="col-md-6 offset-md-3">
        <h2 class="mb-4">Đăng nhập</h2>

        <!-- Hiển thị thông báo lỗi -->
        <c:if test="${not empty alert}">
            <div class="alert alert-danger">${alert}</div>
        </c:if>

        <!-- Hiển thị thông báo thành công -->
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <div class="input-group mb-3">
            <span class="input-group-text"><i class="fa fa-user"></i></span>
            <input type="text" placeholder="Tên đăng nhập" name="username" 
                   class="form-control" required>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text"><i class="fa fa-lock"></i></span>
            <input type="password" placeholder="Mật khẩu" name="password" 
                   class="form-control" required>
        </div>

        <!-- Remember me -->
        <div class="form-check mb-3">
            <input class="form-check-input" type="checkbox" name="remember" id="remember">
            <label class="form-check-label" for="remember">
                Ghi nhớ đăng nhập
            </label>
        </div>

        <button type="submit" class="btn btn-primary btn-block">Đăng nhập</button>

        <p class="mt-3 text-center">
            Bạn chưa có tài khoản? 
            <a href="${pageContext.request.contextPath}/register">Đăng ký</a>
        </p>

        <p class="mt-2 text-center">
            <a href="${pageContext.request.contextPath}/forget-password">Quên mật khẩu?</a>
        </p>
    </form>

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
