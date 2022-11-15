CREATE DATABASE if not exists hang_hoa;
USE hang_hoa;
create table nha_cung_cap(
	id_nha_cc int auto_increment primary key,
    ten_nha_cc varchar(50),
    dia_chi varchar(50)
    );
create table sdt(
	id int auto_increment primary key,
    ten_sdt varchar(50),
    id_nha_cung_cap int,
    foreign key (id_nha_cung_cap) references nha_cung_cap(id_nha_cc)
    ); 
create table phieu_xuat(
	id_phieu_xuat int auto_increment primary key,
    ngay_xuat date
    );
create table phieu_nhap(
	id_phieu_nhap int auto_increment primary key,
    ngay_nhap date
    );
create table vat_tu(
	id_vat_tu int auto_increment primary key,
    ten_vat_tu varchar(50)
    );
create table don_dat_hang(
	id_don_dat_hang int auto_increment primary key,
    ngay_dat_hang date,
    id_nha_cc int,
    foreign key(id_nha_cc) references nha_cung_cap(id_nha_cc)	
    );
create table chi_tiet_phieu_xuat(
	id_phieu_xuat int,
    id_vat_tu int,
    sl_xuat int,
    dg_xuat double,
    primary key(id_phieu_xuat,id_vat_tu),
    foreign key(id_phieu_xuat) references phieu_xuat(id_phieu_xuat),
    foreign key(id_vat_tu) references vat_tu(id_vat_tu)
    );
create table chi_tiet_phieu_nhap(
	id_phieu_nhap int,
    id_vat_tu int,
    sl_nhap int,
    dg_nhap double,
    primary key(id_phieu_nhap,id_vat_tu),
    foreign key (id_phieu_nhap) references phieu_nhap(id_phieu_nhap),
    foreign key (id_vat_tu) references vat_tu(id_vat_tu)
    );
create table chi_tiet_don_dat_hang(
	id_don_dat_hang int,
    id_vat_tu int,
    sl_vat_tu int,
    primary key(id_don_dat_hang,id_vat_tu),
    foreign key(id_don_dat_hang) references don_dat_hang(id_don_dat_hang),
    foreign key(id_vat_tu) references vat_tu(id_vat_tu)
    );
    
