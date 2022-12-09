create database if not exists furama_resort;
drop database if exists furama_resort;
use furama_resort;

create table `position`(
	position_id int auto_increment primary key,
    position_name varchar(45)
);

create table `education_degree`(
	education_degree_id int auto_increment primary key,
    education_degree_name varchar(45)
);

create table `division`(
	division_id int auto_increment primary key,
    division_name varchar(45)
);

create table `user`(
	username varchar(255) primary key,
    `password` varchar(255)
);

create table `role`(
	role_id int auto_increment primary key,
    role_name varchar(255)
);

create table `employee`(
	employee_id int auto_increment primary key,
    employee_name varchar(45),
    date_of_birth date,
    id_card varchar(45) unique,
    salary double,
    phone_number varchar(45),
    email varchar(45),
    address varchar(45),
    position_id int,
    education_degree_id int,
    division_id int,
    username varchar(255),
    foreign key(position_id) references `position`(position_id) on delete cascade,
    foreign key(education_degree_id) references`education_degree`(education_degree_id) on delete cascade,
    foreign key(division_id) references `division`(division_id) on delete cascade,
    foreign key(username) references `user`(username) on delete cascade
);

create table `user_role`(
	role_id int ,
    username varchar(255),
    primary key(role_id,username),
    foreign key(role_id) references `role`(role_id) on delete cascade,
    foreign key(username) references `user`(username) on delete cascade
);

create table `customer_type`(
	customer_type_id int auto_increment primary key,
    customer_type_name varchar(45)
);

create table `customer`(
	customer_id int auto_increment primary key,
    customer_name varchar(45),
    date_of_birth date,
    gender bit(1),
    id_card varchar(45) unique,
    phone_number varchar(45),
    email varchar(45),
    address varchar(45),
    customer_type_id int,
    foreign key(customer_type_id) references `customer_type`(customer_type_id) on delete cascade
);

create table `facility_type`(
	facility_type_id int auto_increment primary key,
    facility_type_name varchar(45)
);

create table `rent_type`(
	rent_type_id int auto_increment primary key,
    rent_type_name varchar(45)
);

create table `facility`(
	facility_id int auto_increment primary key,
    facility_name varchar(45),
    area int,
    cost double,
    max_people int,
    standard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floor int,
    facility_free text,
    rent_type_id int,
    facility_type_id int,
    foreign key(rent_type_id) references `rent_type`(rent_type_id) on delete cascade,
    foreign key(facility_type_id) references `facility_type`(facility_type_id) on delete cascade
);

create table `attach_facility`(
	attach_facility_id int auto_increment primary key,
    attach_facility_name varchar(45),
    cost double,
    unit varchar(10),
    `status` varchar(45)
);

create table `contract`(
	contract_id int auto_increment primary key,
    start_date datetime,
    end_date datetime,
    deposit double,
    employee_id int,
    customer_id int,
    facility_id int,
    foreign key(employee_id) references `employee`(employee_id) on delete cascade,
    foreign key(customer_id) references `customer`(customer_id) on delete cascade,
    foreign key(facility_id) references `facility`(facility_id) on delete cascade
);

create table `contract_detail`(
	contract_detail_id int auto_increment primary key,
    quantity int,
    contract_id int,
    attach_facility_id int,
    foreign key(contract_id) references `contract`(contract_id) on delete cascade,
    foreign key(attach_facility_id) references `attach_facility`(attach_facility_id) on delete cascade
);

-- Thêm dữ liệu vào bảng vị trí
insert into `position` values 
	('1', 'Quản lý'),
	('2', 'Nhân viên');
    
-- Thêm dữ liệu vào bảng trình độ
insert into `education_degree` values
	('1', 'Trung Cấp'),
	('2', 'Cao Đẳng'),
	('3', 'Đại Học'),
	('4', 'Sau Đại Học');
    
-- Thêm dữ liệu vào bảng bộ phận
insert into `division` values
	(1,'Sale-Marketing'),
	(2,'Hành chính'),
	(3,'Phục vụ'),
	(4,'Quản lý');
    
-- Thêm dữ liệu vào bảng tên đăng nhập
insert into `user` values
	('Duc Nguyen','xxxxxx'),
    ('Duy Duc','xxxxxxxxx');
    
-- Thêm dữ liệu vào bảng vai diễn
insert into `role` values
	('1','y tá'),
    ('2','bác sĩ');
     
-- Thêm dữ liệu vào bảng nhân viên
insert into `employee` values
	('1', 'Nguyễn Văn An', '1970-11-07', '456231786', '10000000', '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', '1', '3', '1','Duc Nguyen'),
    ('2', 'Lê Văn Bình', '1997-04-09', '654231234', '7000000', '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', '1', '2', '2','Duc Nguyen'),
    ('3', 'Hồ Thị Yến', '1995-12-12', '999231723', '14000000', '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', '1', '3', '2','Duc Nguyen'),
    ('4', 'Võ Công Toản', '1980-04-04', '123231365', '17000000', '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', '1', '4', '4','Duc Nguyen'),
	('5', 'Nguyễn Bỉnh Phát', '1999-12-09', '454363232', '6000000', '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', '2', '1', '1','Duy Duc'),
	('6', 'Khúc Nguyễn An Nghi', '2000-11-08', '964542311', '7000000', '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', '2', '2', '3','Duy Duc'),
	('7', 'Nguyễn Hữu Hà', '1993-01-01', '534323231', '8000000', '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', '2', '3', '2','Duy Duc'),
	('8', 'Nguyễn Hà Đông', '1989-09-03', '234414123', '9000000', '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', '2', '4', '4','Duy Duc'),
	('9', 'Tòng Hoang', '1982-09-03', '256781231', '6000000', '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', '2', '4', '4','Duy Duc'),
	('10', 'Nguyễn Công Đạo', '1994-01-08', '755434343', '8000000', '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', '2', '3', '2','Duy Duc');
    
-- Thêm dữ liệu vào bảng tên đăng nhập vai diễn
insert into `user_role` values
	(1,'Duc Nguyen'),
    (2,'Duy Duc');
  
-- Thêm dữ liệu vào bảng kiểu khách hàng
insert into `customer_type` values
	('1', 'Diamond'),
	('2', 'Platinum'),
	('3', 'Gold'),
	('4', 'Silver'),
	('5', 'Member');

-- Thêm dữ liệu vào bảng khách hàng
insert into `customer` values
	('1', 'Nguyễn Thị Hào', '1970-11-07', 0 , '643431213', '0945423362', '23 Nguyễn Hoàng, Đà Nẵng', 'thihao07@gmail.com', '5'),
	('2', 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'K77/22 Thái Phiên, Quảng Trị', 'xuandieu92@gmail.com', '3'),
	('3', 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'K323/12 Ông Ích Khiêm, Vinh', 'nghenhan2702@gmail.com', '1'),
	('4', 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'K453/12 Lê Lợi, Đà Nẵng', 'duongquan@gmail.com', '1'),
	('5', 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', '224 Lý Thái Tổ, Gia Lai', 'nhinhi123@gmail.com', '4'),
	('6', 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', '37 Yên Thế, Đà Nẵng', 'tonnuchau@gmail.com', '4'),
	('7', 'Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'K123/45 Lê Lợi, Hồ Chí Minh', 'kimcuong84@gmail.com', '1'),
	('8', 'Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', '55 Nguyễn Văn Linh, Kon Tum', 'haohao99@gmail.com', '3'),
	('9', 'Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', '24 Lý Thường Kiệt, Quảng Ngãi', 'danhhai99@gmail.com', '1'),
	('10', 'Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', '22 Ngô Quyền, Đà Nẵng', 'dactam@gmail.com', '2'),
	('11', 'Nguyễn Văn Tâm', '1989-02-01', 1, '34434382', '0984530121', '23 Ngô Quyền, Đà Nẵng', 'tam@gmail.com', '3');

-- THêm dữ liệu vào bảng kiểu dịch vụ
insert into `facility_type` values
	('1', 'Villa'),
	('2', 'House'),
	('3', 'Room');
    
-- Thêm dữ liệu vào bảng kiểu thuê
insert into `rent_type` values
	('1', 'year'),
	('2', 'month'),
	('3', 'day'),
	('4', 'hour');
    
-- Thêm dữ liệu vào bảng dịch vụ
insert into `facility` values
	('1', 'Villa Beach Front', '25000', '1000000', '10', 'vip', 'Có hồ bơi', 500, '4', null, '3', '1'),
	('2', 'House Princess 01', '14000', '5000000', '7', 'vip', 'Có thêm bếp nướng', null, '3', null, '2', '2'),
	('3', 'Room Twin 01', '5000', '1000000', '2', 'normal', 'Có tivi', null, null, '1 Xe máy, 1 Xe đạp', '4', '3'),
	('4', 'Villa No Beach Front', '22000', '9000000', '8', 'normal', 'Có hồ bơi', '300', '3', null, '3', '1'),
	('5', 'House Princess 02', '10000', '4000000', '5', 'normal', 'Có thêm bếp nướng', null, '2', null, '3', '2'),
	('6', 'Room Twin 02', '3000', '900000', '2', 'normal', 'Có tivi', null, null, '1 Xe máy', '4', '3');
  
-- Thêm dữ liệu vào bảng dịch vụ đi kèm
insert into `attach_facility` values
	('1', 'Karaoke', '10000', 'giờ', 'tiện nghi, hiện tại'),
	('2', 'Thuê xe máy', '10000', 'chiếc', 'hỏng 1 xe'),
	('3', 'Thuê xe đạp', '20000', 'chiếc', 'tốt'),
	('4', 'Buffet buổi sáng', '15000', 'suất', 'đầy đủ đồ ăn, tráng miệng'),
	('5', 'Buffet buổi trưa', '90000', 'suất', 'đầy đủ đồ ăn, tráng miệng'),
	('6', 'Buffet buổi tối', '16000', 'suất', 'đầy đủ đồ ăn, tráng miệng');

-- Thêm dữ liệu vào bảng hợp đồng
insert into `contract` values
	('1', '2020-12-08', '2020-12-08', '0', '3', '1', '3'),
	('2', '2020-07-14', '2020-07-21', '200000', '7', '3', '1'),
	('3', '2021-03-15', '2021-03-17', '50000', '3', '4', '2'),
	('4', '2021-01-14', '2021-01-18', '100000', '7', '5', '5'),
	('5', '2021-07-14', '2021-07-15', '0', '7', '2', '6'),
	('6', '2021-06-01', '2021-06-03', '0', '7', '7', '6'),
	('7', '2021-09-02', '2021-09-05', '100000', '7', '4', '4'),
	('8', '2021-06-17', '2021-06-18', '150000', '3', '4', '1'),
	('9', '2020-11-19', '2020-11-19', '0', '3', '4', '3'),
	('10', '2021-04-12', '2021-04-14', '0', '10', '3', '5'),
	('11', '2021-04-25', '2021-04-25', '0', '2', '2', '1'),
	('12', '2021-05-25', '2021-05-27', '0', '7', '10', '1');
    
-- Thêm dữ liệu vào bảng hợp đồng chi tiết
insert into `contract_detail` values
	('1', '5', '2', '4'),
	('2', '8', '2', '5'),
	('3', '12', '2', '6'),
	('4', '1', '3', '1'),
	('5', '11', '3', '2'),
	('6', '1', '1', '3'),
	('7', '2', '1', '2'),
	('8', '2', '5', '2');
    
select* from customer where customer_name='NAM ML';
select * from customer;

select * from customer_type;
    
select c.customer_id,c.customer_name,c.date_of_birth,c.gender,c.id_card,c.phone_number,c.email,c.address ,ct.customer_type_id, ct.customer_type_name from customer c
    join customer_type as ct on c.customer_type_id = ct.customer_type_id;
    
select c.customer_id,c.customer_name,c.date_of_birth,c.gender,c.id_card,c.phone_number,c.email,c.address , ct.customer_type_name from customer c
    join customer_type as ct on c.customer_type_id = ct.customer_type_id
    where customer_id = 2;
    
select c.customer_id,c.customer_name,c.date_of_birth,c.gender,c.id_card,c.phone_number,c.email,c.address , ct.customer_type_name from customer c
    join customer_type as ct on c.customer_type_id = ct.customer_type_id
    where customer_name like '%c%';
    
delete from customer where customer_id = 5;

update customer set customer_name = 'a',date_of_birth ='2020-12-12', gender = 0, id_card = '1212121212',phone_number = '1231231231', email='asda',address = 'dasd',customer_type_id ='2' where customer_id = 2;

select c.*, ct.customer_type_name from customer c
    join customer_type as ct on c.customer_type_id = ct.customer_type_id
    where customer_name = 'NAM ML';
    
select c.*, ct.customer_type_name from customer c
    join customer_type as ct on c.customer_type_id = ct.customer_type_id
    where gender = true;
    
select f.facility_id,f.facility_name,f.area,f.cost,f.max_people,f.standard_room,f.description_other_convenience,f.pool_area,f.number_of_floor,f.facility_free, ft.facility_type_name,rt.rent_type_name from facility as f 
join facility_type as ft on f.facility_type_id = ft.facility_type_id
join rent_type as rt on f.rent_type_id = rt.rent_type_id;

select f.facility_id,f.facility_name,f.area,f.cost,f.max_people,f.standard_room,f.description_other_convenience,f.pool_area,f.number_of_floor,f.facility_free, ft.facility_type_name,rt.rent_type_name from facility as f 
join facility_type as ft on f.facility_type_id = ft.facility_type_id
join rent_type as rt on f.rent_type_id = rt.rent_type_id
where facility_id = 2;

select * from rent_type;

select * from facility_type;

select * from facility;

select * from facility_type;

update facility set facility_name = 'abbaaa',area='3',cost='5435',max_people='3',standard_room='fsdf',description_other_convenience='asdas',pool_area='34',number_of_floor='2',facility_free='3f',rent_type_id='3',facility_type_id='2' where facility_id =6 ;

delete from facility where facility_id = 1;
insert into facility (facility_name,area,cost,max_people,standard_room,description_other_convenience,pool_area,number_of_floor,rent_type_id,facility_type_id) 
values ('villa resort',25000,10000000,10,'VIP','có nhà',400,2,2,2);

insert into facility(facility_name, area, cost, max_people, standard_room, description_other_convenience, number_of_floor, facility_free, rent_type_id, facility_type_id) 
            value ('a',2,3,2,'wds','asdas',32,'đá',1,1);