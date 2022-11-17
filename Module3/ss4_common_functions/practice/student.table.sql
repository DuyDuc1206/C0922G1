create database quan_ly_sinh_vien_2;
use quan_ly_sinh_vien_2;

create table class(
	id int auto_increment primary key,
   `name` varchar(30)
);
create table instructor(
	id int auto_increment primary key,
    `name` varchar(30),
    birhtday datetime,
    salary double
);
create table instructor_class(
	instructor int ,
    class_id int,
    start_time datetime,
	primary key(instructor, class_id),
    foreign key(instructor) references instructor(id),
    foreign key(class_id) references class(id)
);
    
create table student(
	id int auto_increment primary key,
    `name` varchar(30),
    gender bit(1),
    birthday datetime,
    email varchar(30),
    `point` double,
    username varchar(30),
    class_id int,
    foreign key(class_id) references class(id)
);
drop table instructor_class;

    