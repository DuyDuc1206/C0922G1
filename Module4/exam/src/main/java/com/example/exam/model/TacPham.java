package com.example.exam.model;

import javax.persistence.*;

@Entity
public class TacPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ten;
    private String hoaSi;
    private int namVe;
    private String kichThuoc;
    @ManyToOne
    private TheLoai theLoai;

    public TacPham() {
    }

    public TacPham(Integer id, String ten, String hoaSi, int namVe, String kichThuoc, TheLoai theLoai) {
        this.id = id;
        this.ten = ten;
        this.hoaSi = hoaSi;
        this.namVe = namVe;
        this.kichThuoc = kichThuoc;
        this.theLoai = theLoai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHoaSi() {
        return hoaSi;
    }

    public void setHoaSi(String hoaSi) {
        this.hoaSi = hoaSi;
    }

    public int getNamVe() {
        return namVe;
    }

    public void setNamVe(int namVe) {
        this.namVe = namVe;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }
}
