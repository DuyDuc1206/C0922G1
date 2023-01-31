package repository;


import model.LoaiVanPhong;

import java.util.List;

public interface ILoaiVanPhongRepository {
   List<LoaiVanPhong> selectAllLoaiVanPhong();
}
