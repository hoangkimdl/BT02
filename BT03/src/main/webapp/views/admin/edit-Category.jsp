<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa danh mục</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        .content { padding: 20px; }
        .form-group img { border-radius: 10px; margin-bottom: 10px; }
    </style>
</head>
<body>
<div class="content">
    <h2>Chỉnh sửa danh mục</h2>
    <p>Nơi bạn có thể chỉnh sửa danh mục</p>

    <form role="form" action="<c:url value='/admin/category/edit'/>" method="post" enctype="multipart/form-data">
        <input name="id" value="${category.id}" type="hidden">

        <div class="form-group">
            <label>Tên danh mục:</label>
            <input type="text" class="form-control" value="${category.name}" name="name" required />
        </div>

        <div class="form-group">
            <c:url value="/downloadImage?file=${category.icon}" var="imgUrl"/>
            <img class="img-responsive" width="100px" src="${imgUrl}" alt="">
            <label>Ảnh đại diện</label>
            <input type="file" name="icon" class="form-control-file" />
        </div>

        <button type="submit" class="btn btn-primary">Cập nhật</button>
        <button type="reset" class="btn btn-secondary">Hủy</button>
    </form>
</div>
</body>
</html>
