<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="login" method="post">
		<h2>Đăng nhập vào hệ thống </h2>
		<c:if test="${alert !=null}">
			<h3 class="alert alertdanger">${alert}</h3>
		</c:if>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Tài khoản" name="username"
						class="form-control">
				</div>
			</label> <label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="password" placeholder="Mật khẩu" name="password"
						class="form-control">
				</div>
			</label>

		</section>
		<button type="submit" class="btn btn-primary">Đăng nhập</button>
	</form>
</body>
</html>