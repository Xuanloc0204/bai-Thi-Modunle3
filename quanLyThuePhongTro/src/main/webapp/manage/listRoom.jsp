<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/06/2024
  Time: 09:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý thuê phòng trọ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Danh sách phòng trọ</h2>

    <form action="manage/search.jsp" method="get" class="mb-4">
        <div class="input-group">
            <input type="text" class="form-control" name="search" placeholder="Tìm kiếm..." aria-label="Tìm kiếm">
            <button class="btn btn-primary" type="submit">Tìm kiếm</button>
        </div>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Mã phòng trọ</th>
            <th>Tên người thuê</th>
            <th>Số điện thoại</th>
            <th>Ngày bắt đầu thuê</th>
            <th>Hình thức thanh toán</th>
            <th>Ghi chú</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><c:out value="${user.MaPhong}"/></td>
            <td><c:out value="${user.TenNguoiThue}"/></td>
            <td><c:out value="${user.SoDienThoai}"/></td>
            <td><c:out value="${user.NgayBatDau}"/></td>
            <td><c:out value="${user.MaHinhThucThanhToan}"/></td>
            <td><c:out value="${user.GhiChu}"/></td>
            <td>
                <button class="btn btn-danger">Xóa</button>
                <button class="btn btn-warning">Sửa</button>
            </td>
        </tr>
        </tbody>
    </table>

    <!-- Nút thêm phòng trọ mới -->
    <a href="manage/addRoom.jsp" class="btn btn-success">Thêm mới</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
