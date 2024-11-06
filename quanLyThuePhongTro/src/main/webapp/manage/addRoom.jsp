<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/06/2024
  Time: 09:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Thêm phòng trọ</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <h2 class="text-center">Thêm phòng trọ mới</h2>

  <!-- Form tạo phòng trọ -->
  <form action="addRoom.jsp" method="post">
    <div class="mb-3">
      <label for="TenNguoiThue" class="form-label">Tên người thuê:</label>
      <input type="text" class="form-control" id="TenNguoiThue" name="TenNguoiThue" required>
    </div>

    <div class="mb-3">
      <label for="SoDienThoai" class="form-label">Số điện thoại:</label>
      <input type="text" class="form-control" id="SoDienThoai" name="SoDienThoai" required>
    </div>

    <div class="mb-3">
      <label for="NgayBatDau" class="form-label">Ngày bắt đầu thuê:</label>
      <input type="date" class="form-control" id="NgayBatDau" name="NgayBatDau" required>
    </div>

    <div class="mb-3">
      <label for="MaHinhThucThanhToan" class="form-label">Hình thức thanh toán:</label>
      <select class="form-control" id="MaHinhThucThanhToan" name="MaHinhThucThanhToan" required>
        <option value="1">Theo tháng</option>
        <option value="2">Theo quý</option>
        <option value="3">Theo năm</option>
      </select>
    </div>

    <div class="mb-3">
      <label for="GhiChu" class="form-label">Ghi chú:</label>
      <textarea class="form-control" id="GhiChu" name="GhiChu"></textarea>
    </div>

    <button type="submit" class="btn btn-primary">Tạo mới</button>
  </form>

  <a href="listRoom.jsp" class="btn btn-secondary mt-3">Quay lại</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
