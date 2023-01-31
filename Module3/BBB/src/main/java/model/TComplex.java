package model;

public class TComplex {
    private int id;
    private String ten;
    private double dienTich;
    private String trangThai;
    private int tang;
    private LoaiVanPhong loaiVanPhong;
    private double gia;
    private String ngayBatDau;
    private String ngayKetThuc;
    private int loaiThue;

    public TComplex() {
    }

    public TComplex(int id, String ten, double dienTich, String trangThai, int tang, LoaiVanPhong loaiVanPhong, double gia, String ngayBatDau, String ngayKetThuc, int loaiThue) {
        this.id = id;
        this.ten = ten;
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiVanPhong = loaiVanPhong;
        this.gia = gia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.loaiThue = loaiThue;
    }

    public TComplex(int id, String ten, double dienTich, String trangThai, int tang, LoaiVanPhong loaiVanPhong, double gia, String ngayBatDau, String ngayKetThuc) {
        this.id = id;
        this.ten = ten;
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiVanPhong = loaiVanPhong;
        this.gia = gia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public LoaiVanPhong getLoaiVanPhong() {
        return loaiVanPhong;
    }

    public void setLoaiVanPhong(LoaiVanPhong loaiVanPhong) {
        this.loaiVanPhong = loaiVanPhong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getLoaiThue() {
        return loaiThue;
    }

    public void setLoaiThue(int loaiThue) {
        this.loaiThue = loaiThue;
    }
}
