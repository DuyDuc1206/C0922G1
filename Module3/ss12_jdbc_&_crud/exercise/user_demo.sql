create database if not exists demo;
drop database if exists demo;
use demo;

create table users (
	id int(3) auto_increment primary key,
    `name` varchar(120) ,
    email varchar(220) ,
    country varchar(120) 
);
    
insert into users(`name`,email,country) 
values
	('Minh','duy@gmail.com','viet nam'),
	('Nhan','abc@gmail.com','Japan');

select * from users;
