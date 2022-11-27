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
    salatry double,
    phone_number varchar(45),
    email varchar(45),
    address varchar(45),
    position_id int,
    education_degree_id int,
    division_id int,
    username varchar(255),
    foreign key(position_id) references `position`(position_id),
    foreign key(education_degree_id) references`education_degree`(education_degree_id),
    foreign key(division_id) references `division`(division_id),
    foreign key(username) references `user`(username)
);

create table `user_role`(
	role_id int ,
    username varchar(255),
    primary key(role_id,username),
    foreign key(role_id) references `role`(role_id),
    foreign key(username) references `user`(username)
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
    foreign key(customer_type_id) references `customer_type`(customer_type_id)
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
    foreign key(rent_type_id) references `rent_type`(rent_type_id),
    foreign key(facility_type_id) references `facility_type`(facility_type_id)
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
    foreign key(employee_id) references `employee`(employee_id),
    foreign key(customer_id) references `customer`(customer_id),
    foreign key(facility_id) references `facility`(facility_id)
);

create table `contract_detail`(
	contract_detail_id int auto_increment primary key,
    quantity int,
    contract_id int,
    attach_facility_id int,
    foreign key(contract_id) references `contract`(contract_id),
    foreign key(attach_facility_id) references `attach_facility`(attach_facility_id)
);