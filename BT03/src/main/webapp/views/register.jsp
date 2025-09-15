<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tạo tài khoản</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" 
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body class="container mt-5">
    <form action="${pageContext.request.contextPath}/register" method="post" class="col-md-6 offset-md-3">
        <h2 class="mb-4">Tạo tài khoản mới</h2>
        
        <!-- Hiển thị thông báo lỗi -->
        <c:if test="${alert != null}">
            <div class="alert alert-danger">${alert}</div>
        </c:if>

        <!-- Username -->
        <div class="input-group mb-3">
            <span class="input-group-text"><i class="fa fa-user"></i></span>
            <input type="text" placeholder="Tài khoản" name="username"
                   class="form-control" required>
        </div>

        <!-- Fullname -->
        <div class="input-group mb-3">
            <span class="input-group-text"><i class="fa fa-id-card"></i></span>
            <input type="text" placeholder="Họ và tên" name="fullname"
                   class="form-control" required>
        </div>

        <!-- Email -->
        <div class="input-group mb-3">
            <span class="input-group-text"><i class="fa fa-envelope"></i></span>
            <input type="email" placeholder="Nhập Email" name="email"
                   class="form-control" required>
        </div>

        <!-- Phone -->
        <div class="input-group mb-3">
            <span class="input-group-text"><i class="fa fa-phone"></i></span>
            <input type="text" placeholder="Số điện thoại" name="phone"
                   class="form-control" required>
        </div>

        <!-- Password -->
        <div class="input-group mb-3">
            <span class="input-group-text"><i class="fa fa-lock"></i></span>
            <input type="password" placeholder="Mật khẩu" name="password"
                   class="form-control" required>
        </div>

        <!-- Re-enter Password -->
        <div class="input-group mb-3">
            <span class="input-group-text"><i class="fa fa-lock"></i></span>
            <input type="password" placeholder="Nhập lại mật khẩu" name="repassword"
                   class="form-control" required>
        </div>

        <!-- Submit -->
        <button type="submit" class="btn btn-primary btn-block">Tạo tài khoản</button>
    </form>

    <!-- Bootstrap JS + jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
