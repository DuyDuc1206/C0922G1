package com.example.exam.repository;

import com.example.exam.model.TacPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITacPhamRepository extends JpaRepository<TacPham, Integer> {
    @Query(value = "select * from tac_pham where tac_pham.ten like concat('%',:ten,'%') and tac_pham.the_loai_id like concat('%',:theLoai,'%') ", nativeQuery = true)
    Page<TacPham> findAll(@Param("ten") String ten, @Param("theLoai") String theLoai, Pageable pageable );
}
