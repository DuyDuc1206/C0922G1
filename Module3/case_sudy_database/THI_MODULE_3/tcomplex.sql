create database  if not exists TComplex;
drop database if exists TComplex;
use TComplex;

create table loai_mat_bang(
	ma_loai_mat_bang int auto_increment primary key,
    ten_mat_bang varchar(45)
);
create table mat_bang(
	id int auto_increment primary key,
	ten_mb varchar(45),
    trang_thai varchar(45),
    dien_tich double ,
    tang int,
    gia_tien double,
    ngay_bat_dau date,
    ngay_ket_thuc date,
    ma_loai_mat_bang int,
    foreign key(ma_loai_mat_bang) references loai_mat_bang(ma_loai_mat_bang) on delete cascade
);

INSERT INTO `tcomplex`.`loai_mat_bang` (`ma_loai_mat_bang`, `ten_mat_bang`) VALUES ('1', 'Văn Phòng chia sẻ');
INSERT INTO `tcomplex`.`loai_mat_bang` (`ma_loai_mat_bang`, `ten_mat_bang`) VALUES ('2', 'Văn phòng trọng gói');
    
INSERT INTO `tcomplex`.`mat_bang` (`id`, `ten_mb`, `dien_tich`, `tang`, `gia_tien`, `ngay_bat_dau`, `ngay_ket_thuc`, `ma_loai_mat_bang`) VALUES ('1', 'MB001', '200000', '150', '20000000', '2020-08-07', '2021-09-03', '1');
INSERT INTO `tcomplex`.`mat_bang` (`id`, `ten_mb`, `dien_tich`, `tang`, `gia_tien`, `ngay_bat_dau`, `ngay_ket_thuc`, `ma_loai_mat_bang`) VALUES ('2', 'MB002', '5000000', '240', '500000', '2020-08-09', '2021-02-10', '2');