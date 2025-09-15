<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý danh mục</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.sidebar {
	background-color: #007bff;
	height: 100vh;
	color: white;
	padding: 20px;
}

.sidebar a {
	display: block;
	color: white;
	padding: 10px;
	margin-bottom: 5px;
	border-radius: 5px;
	text-decoration: none;
}

.sidebar a:hover {
	background-color: #0056b3;
}

.sidebar .active {
	background-color: #dc3545;
}

.topbar {
	background-color: #007bff;
	padding: 10px;
	color: white;
	text-align: right;
}

.topbar button {
	margin-left: 10px;
}

.content {
	padding: 20px;
}

h2 {
	color: red;
	margin-bottom: 10px;
}

.table img {
	border-radius: 10px;
}

.pagination-bar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 20px;
	background-color: #f8f9fa;
	padding: 10px;
	border-radius: 5px;
}

.pagination-bottom {
	display: flex;
	justify-content: center;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<!-- Sidebar -->
			<div class="col-md-2 sidebar">
				<div class="text-center mb-3">
					<img src="https://via.placeholder.com/120"
						class="rounded-circle mb-2">
					<p>
						<b>Bạn là Admin</b>
					</p>
				</div>
				<a href="<c:url value='/admin/dashboard'/>"
					class="${fn:contains(pageContext.request.requestURI, 'dashboard') ? 'active' : ''}">Dashboard</a>
				<div class="menu-group">
					<a href="#"
						class="menu-title ${fn:contains(pageContext.request.requestURI, 'category') ? 'active' : ''}">Quản
						lý Danh mục</a>
					<div class="submenu">
						<a href="<c:url value='/admin/category/add'/>">Thêm danh mục
							mới</a> <a href="<c:url value='/admin/category/list'/>">Danh sách
							danh mục</a>
					</div>
				</div>
			</div>

			<!-- Main content -->
			<div class="col-md-10">
				<!-- Topbar -->
				<div class="topbar">
					Xin chào Hoàng Kim <a href="<c:url value='/logout'/>"
						class="btn btn-danger btn-sm">Đăng xuất</a>
				</div>

				<div class="content">
					<h2>Quản lý danh mục</h2>
					<p>Nơi bạn có thể quản lý danh mục của mình</p>

					<!-- Form để submit khi thay đổi -->
					<form id="filterForm" method="get"
						action="<c:url value='/admin/category/list'/>">
						<input type="hidden" name="page" value="${currentPage}">
					</form>

					<!-- Thanh tìm kiếm và dropdown số bản ghi -->
					<div class="pagination-bar">
						<div>
							<label>Danh sách danh mục</label> <select name="recordsPerPage"
								form="filterForm" onchange="this.form.submit()">
								<option value="5" ${recordsPerPage == 5 ? 'selected' : ''}>5
									records per page</option>
								<option value="10" ${recordsPerPage == 10 ? 'selected' : ''}>10
									records per page</option>
								<option value="20" ${recordsPerPage == 20 ? 'selected' : ''}>20
									records per page</option>
							</select>
						</div>
						<div>
							<input type="text" name="search" form="filterForm"
								value="${search}" placeholder="Search:"
								onkeyup="if(event.keyCode==13) this.form.submit();">
						</div>
					</div>

					<table class="table table-bordered table-striped">
						<thead class="thead-dark">
							<tr>
								<th>STT</th>
								<th>Hình ảnh</th>
								<th>Tên danh mục</th>
								<th>Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cateList}" var="cate" varStatus="stt">
								<tr>
									<td>${stt.index + 1 + (currentPage - 1) * recordsPerPage}</td>
									<!-- STT tính theo phân trang -->
									<c:url value="/downloadImage?file=${cate.icon}" var="imgUrl" />
									<td><img src="${imgUrl}" width="100" height="130"></td>
									<td>${cate.name}</td>
									<td><a
										href="<c:url value='/admin/category/edit?id=${cate.id}'/>"
										class="btn btn-sm btn-warning">Sửa</a> <a
										href="<c:url value='/admin/category/delete?id=${cate.id}'/>"
										class="btn btn-sm btn-danger">Xóa</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<!-- Thanh phân trang ở cuối -->
					<div class="pagination-bottom">
						<nav aria-label="Page navigation">
							<ul class="pagination">
								<li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
									<a class="page-link"
									href="<c:url value='/admin/category/list?page=${currentPage - 1}&recordsPerPage=${recordsPerPage}&search=${search}'/>"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a>
								</li>
								<c:forEach begin="1" end="${totalPages}" var="i">
									<li class="page-item ${currentPage == i ? 'active' : ''}">
										<a class="page-link"
										href="<c:url value='/admin/category/list?page=${i}&recordsPerPage=${recordsPerPage}&search=${search}'/>">${i}</a>
									</li>
								</c:forEach>
								<li
									class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
									<a class="page-link"
									href="<c:url value='/admin/category/list?page=${currentPage + 1}&recordsPerPage=${recordsPerPage}&search=${search}'/>"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a>
								</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>