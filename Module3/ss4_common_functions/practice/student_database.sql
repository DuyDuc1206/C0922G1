create database student_management_database;
use quan_ly_sinh_vien_2;

insert into class
values
	(1,'c0711g1'),
	(2,'c0811g1'),
	(3,'c0911g1');
    
insert into student
values 
	(1,'nguyen ngoc cu',1,'1981-12-12',null,8,'conh',1),
	(2,'nguyen ngoc cu',1,'1981-10-12',null,6,'asdasdasdasdnh',1),
	(3,'nguyen sdfsdfoc cu',1,'1981-8-12',null,5,'asddasdasdnh',2),
	(4,'nguyen sdfsdfoc cu',1,'1981-7-12',null,5,'assdasdnh',2),
	(5,'nguasdn sdfsdfoc cu',1,'1981-6-12',null,3,'asddanbnvbnh',1),
	(6,'ngasden sdfsdfoc cu',1,'1981-5-12',null,5,'aasdnh',2);

insert into instructor
values
	(1,'tran van chanh','1985-02-02',100),
	(2,'van chanh','1990-02-02',200),
	(3,'van chanh sdad','1970-02-02',300),
	(4,'van chadsaddadnh sdad','1995-02-02',100);
    
insert into instructor_class
values
	(1,1,null),
	(1,2,null),
	(1,3,null),
	(2,1,null),
	(2,2,null),
	(2,3,null);
select class.name , count(student.class_id) as so_luong
from class
join student
on class.id = student.class_id
group by class.name;

select max(point)
from student;

select class.name,avg(point)
from class
join student
on class.id = student.class_id
group by class.name;

select 'instructor' as type , name
from instructor
union
select 'student' as type, name
from student;

select s.name,instructor.birthday
from student s
left join instructor i
on s.id = i.id;


    