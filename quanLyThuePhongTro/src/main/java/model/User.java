package model;

public class User {
    protected int MaPhong;
    protected String TenNguoiThue;
    protected String SoDienThoai;
    protected String NgayBatDau;
    protected int MaHinhThucThanhToan;
    protected String GhiChu;

    public User(int maPhong, String tenNguoiThue, String soDienThoai, String ngayBatDau, int maHinhThucThanhToan, String ghiChu) {
        super();
        this.MaPhong = maPhong;
        TenNguoiThue = tenNguoiThue;
        SoDienThoai = soDienThoai;
        NgayBatDau = ngayBatDau;
        MaHinhThucThanhToan = maHinhThucThanhToan;
        GhiChu = ghiChu;
    }
    public User(String tenNguoiThue, String soDienThoai, String ngayBatDau, int maHinhThucThanhToan, String ghiChu) {
        super();
        TenNguoiThue = tenNguoiThue;
        SoDienThoai = soDienThoai;
        NgayBatDau = ngayBatDau;
        MaHinhThucThanhToan = maHinhThucThanhToan;
        GhiChu = ghiChu;
    }

    public User() {
    }

    public int getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(int maPhong) {
        this.MaPhong = maPhong;
    }

    public String getTenNguoiThue() {
        return TenNguoiThue;
    }

    public void setTenNguoiThue(String tenNguoiThue) {
        TenNguoiThue = tenNguoiThue;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        NgayBatDau = ngayBatDau;
    }

    public int getMaHinhThucThanhToan() {
        return MaHinhThucThanhToan;
    }

    public void setMaHinhThucThanhToan(int maHinhThucThanhToan) {
        MaHinhThucThanhToan = maHinhThucThanhToan;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }
}
