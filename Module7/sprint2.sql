create database sprint2;
drop database sprint2;
use sprint2;

create table `role`(
role_id int primary key auto_increment,
role_name varchar(50)
);

create table `account`(
account_id int auto_increment primary key,
username varchar(50),
`password` varchar(50),
email varchar(50),
encrypt_password varchar(50),
flag_delete bit(1),
avatar varchar(255)
);

-- create table social_account(
-- social_account_id int auto_increment primary key,
-- account_id int,
-- social_token varchar(50)

create table `account_role`(
account_id int,
role_id int,
foreign key (account_id) references `account`(account_id),
foreign key (role_id) references `role`(role_id)
);

create table `lesson`(
lesson_id int auto_increment primary key,
lesson_name varchar(50),
lesson_content text
);

create table `course`(
course_id int auto_increment primary key,
course_name varchar(50),
course_description text,
thumbnail text,
price double,
course_duration int,
created_at date,
lesson_id int,
foreign key(lesson_id) references `lesson`(lesson_id)
);

create table `order`(
order_id int auto_increment primary key,
account_id int,
flag_delete bit(1),
order_date date,
foreign key(account_id) references `account`(account_id)
);

create table order_detail(
order_id int,
course_id int,
foreign key(order_id) references `order`(order_id),
foreign key(course_id) references `course`(course_id)
);

create table payment(
pay_id int auto_increment primary key,
payment_method varchar(45),
order_id int,
foreign key(order_id) references `order`(order_id)
);


