create database furama_query;
use furama_table;

-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien
where ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%' and length(ho_ten)<=15;

-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang
where dia_chi like '% ĐÀ Nẵng' or dia_chi like '% Quảng Trị'
having (year(curdate()) - year(ngay_sinh)) between 18 and 50;

-- 4. Mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Sắp xếp theo số lần đăt phòng. chỉ đếm khách hàng có tên loại khách 'diamond'
select kh.ho_ten, count(hd.ma_khach_hang) as 'so_lan_dat_phong' from khach_hang kh
join hop_dong hd
on kh.ma_khach_hang = hd.ma_khach_hang
where kh.ma_loai_khach = 1
group by hd.ma_khach_hang;

-- 5. Hiển thị mã khách hàng , họ tên, tên loại khách,mã hợp đồng ,tên dịch vụ,ngày làm hợp đồng, ngày kết thúc , tổng tiền cho tất cả các khách hàng đã từng đặt phòng 
select distinct kh.ma_khach_hang, kh.ho_ten,hd.ma_khach_hang, hd.ma_hop_dong,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,dv.ten_dich_vu, (dv.chi_phi_thue + (hdct.so_luong * dvdk.gia)) 'tong_tien'
from khach_hang kh
left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem;

-- 6. HIển thị mã dịch vụ, tên dịch vụ, diện tích, chi phí thuê, tên loại dịch vụ của tất cả các dịch vụ chưa từng được khách hàng thực hiện dặt từ quý 1của năm 2021
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
join hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
where year(hd.ngay_lam_hop_dong) < 2021;

-- 7. Hiển thị thông tin mã dịch vụ, tên dịch vụ, diện tích, số người tối đa, chi phí thuê, tên loại dịch vụ
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu,hd.ngay_lam_hop_dong
from dich_vu dv
join hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
where year(hd.ngay_lam_hop_dong) not in (2021);

-- 8. Hiển thị thông tin họ và tên khách hàng có trong hệ thống, với yêu cầu họ tên không trùng nhau
	-- cach 1
select ho_ten from khach_hang
group by ho_ten;

	-- cach 2
select distinct ho_ten from khach_hang;

	-- cach 3
select ho_ten from khach_hang
union
select ho_ten from khach_hang;

-- 9. thống kê doanh thu theo thang
select month(ngay_lam_hop_dong) 'Month', count(ngay_lam_hop_dong) 'so_hop_dong' from hop_dong
group by month(ngay_lam_hop_dong) 
order by month(ngay_lam_hop_dong);

-- 10. Hiển thị thông tin từng hợp đồng thì sử dụng bao nhiêu dịch vụ đi kèm
select hd.ma_hop_dong,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,hd.tien_dat_coc, ifnull(sum(hdct.so_luong),0) 'So_luong_dich_vu_di_kem'
from hop_dong hd
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
group by hd.ma_hop_dong;

-- 11. Hiển thị thông tin các dịch vụ đi kèm bởi khách hàng Diamond và địa chỉ ở Vinh or quảng Ngãi
select dvdk.*
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong








