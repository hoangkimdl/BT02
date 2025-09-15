<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm danh mục mới</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        .content { padding: 20px; }
    </style>
</head>
<body>
<div class="content">
    <h2>Thêm danh mục mới</h2>
    <p>Nơi bạn có thể thêm danh mục mới</p>

    <form role="form" action="<c:url value='/admin/category/add'/>" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label>Tên danh mục:</label>
            <input class="form-control" placeholder="Nhập tên danh mục" name="name" required />
        </div>

        <div class="form-group">
            <label>Ảnh đại diện</label>
            <input type="file" name="icon" class="form-control-file" required />
        </div>

        <button type="submit" class="btn btn-primary">Thêm</button>
        <button type="reset" class="btn btn-secondary">Hủy</button>
    </form>
</div>
</body>
</html>
