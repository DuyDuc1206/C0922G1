create database student_management_database;
use student_management_database;
create table class(
	classId int not null auto_increment primary key,
    className varchar(60) not null,
    startDate datetime not null,
    status bit
);
create table student(
	studentId int not null auto_increment primary key,
    studentName varchar(30) not null,
    address varchar(50),
    phone varchar(20),
    status bit,
    classId int,
    foreign key(classId) references class ( classId)
);
create table `subject`(
	subId int not null auto_increment primary key,
    subName varchar(30) not null,
    credit tinyint not null default 1 check( credit>=1),
    status bit default 1
);
create table mark(
	markId int not null auto_increment primary key,
    mark float default 0 check ( mark between 0 and 100 ),
    examTimes tinyint default 1,
    subId int not null,
    studentId int not null,
    unique(subId,studentId),
    foreign key(subId) references `subject`(subId),
    foreign key(studentId) references student(studentId)
);
DROP database student_management_database;