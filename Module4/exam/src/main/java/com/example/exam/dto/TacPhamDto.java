package com.example.exam.dto;

import com.example.exam.model.TacPham;
import com.example.exam.model.TheLoai;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TacPhamDto implements Validator {
    private Integer id;
    @NotEmpty(message = "{Tên tác phẩm không được để trống}")
    private String ten;
    @NotEmpty(message = "{Tên họa sĩ không được để trống}")
    private String hoaSi;
    @NotNull
    private int namVe;
    @NotEmpty(message = "{Kích thước không được để trống}")
    private String kichThuoc;
    @ManyToOne
    private TheLoai theLoai;

    public TacPhamDto() {
    }

    public TacPhamDto(Integer id, String ten, String hoaSi, int namVe, String kichThuoc, TheLoai theLoai) {
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
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TacPhamDto tacPhamDto = (TacPhamDto) target;
        int currentYear = LocalDate.now().getYear();
        if (tacPhamDto.getNamVe() <=0 ||tacPhamDto.getNamVe()>currentYear){
            errors.rejectValue("namVe","errors.namVe","nam ve khong duoc lon hon nam hien tai");
        }
    }
}
