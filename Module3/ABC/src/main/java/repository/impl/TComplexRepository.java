package repository.impl;

import model.LoaiVanPhong;
import model.TComplex;
import repository.BaseRepository;
import repository.ITComplexRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TComplexRepository implements ITComplexRepository {
    private static final String SELECT_TCOMPLEX = "select mb.id,mb.ten_mb,mb.trang_thai,mb.dien_tich,mb.tang,mb.gia_tien,mb.ngay_bat_dau, mb.ngay_ket_thuc, lmb.ten_mat_bang from mat_bang as mb join loai_mat_bang as lmb where mb.ma_loai_mat_bang = lmb.ma_loai_mat_bang;";
    @Override
    public List<TComplex> selectAllTComplex() {
        List<TComplex> tComplexList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_TCOMPLEX);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("ten_mb");
                String trangThai = rs.getString("trang_thai");
                double dienTich = rs.getDouble("dien_tich");
                int tang = rs.getInt("tang");
                double giaTien = rs.getDouble("gia_tien");
                String ngayBatDau = rs.getString("ngay_bat_dau");
                String ngayKetThuc = rs.getString("ngay_ket_thuc");
                String tenLoai = rs.getString("ten_mat_bang");
                LoaiVanPhong loaiVanPhong = new LoaiVanPhong(tenLoai);
                TComplex tComplex = new TComplex(id,name,dienTich,trangThai,tang,loaiVanPhong,giaTien,ngayBatDau,ngayKetThuc);
                tComplexList.add(tComplex);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tComplexList;
    }
}
