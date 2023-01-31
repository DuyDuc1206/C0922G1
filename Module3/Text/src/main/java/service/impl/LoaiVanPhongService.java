package service.impl;

import model.LoaiVanPhong;
import repository.ILoaiVanPhongRepository;
import repository.impl.LoaiVanPhongRepository;
import service.ILoaiVanPhongService;

import java.util.List;

public class LoaiVanPhongService implements ILoaiVanPhongService {
    ILoaiVanPhongRepository loaiVanPhongRepository = new LoaiVanPhongRepository();
    @Override
    public List<LoaiVanPhong> selectAllLoaiVanPhong() {
        return loaiVanPhongRepository.selectAllLoaiVanPhong();
    }
}
