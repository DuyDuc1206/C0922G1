create database furama_query;
use furama_table;

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien
where ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%' and length(ho_ten)<=15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang
where dia_chi like '% ĐÀ Nẵng' or dia_chi like '% Quảng Trị'
having (year(curdate()) - year(ngay_sinh)) between 18 and 50;

-- Mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Sắp xếp theo số lần đăt phòng. chỉ đếm khách hàng có tên loại khách 'diamond'
select kh.ho_ten, count(hd.ma_khach_hang) as 'so_lan_dat_phong' from khach_hang kh
join hop_dong hd
on kh.ma_khach_hang = hd.ma_khach_hang
where kh.ma_loai_khach = 1
group by hd.ma_khach_hang;


