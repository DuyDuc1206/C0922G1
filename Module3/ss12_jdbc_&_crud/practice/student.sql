create database student_management;
use student_management;

create table student (
	id int auto_increment primary key,
    `name` varchar(30),
    email varchar(30),
    country varchar(30)
);

insert into student (`name`,email,country) values
	('Minh','duy@gmail.com','viet nam'),
	('Nhan','abc@gmail.com','Japan');
    
select * from student where id = 1;

select *from student;

update student 
set `name` = `NamN`, email = `adasd`, country = `nhatban` 
where id = 1;

delimiter //
create procedure p_select()
begin
select * from student;
end //
delimiter ;

call p_select;

delimiter //
create procedure p_edit(in new_name varchar(40), new_email varchar(40), new_country varchar(40), new_id int )
begin
update student set `name` = new_name, email=new_email, country=new_country where id = new_id;
end //
delimiter ;
drop procedure p_edit;
call p_edit(2,'duc','a','cccc');
call P_select;

delimiter //
create procedure p_delete(in new_id int)
begin
delete from student where id = new_id;
end //
delimiter ;

call p_delete(3);
call p_select;