CREATE DATABASE sales_management_database;
USE sales_management_database;
CREATE TABLE customer(
	cId int auto_increment primary key,
    cName varchar(30),
    cAge int 
);
CREATE TABLE `order`(
	oId int auto_increment primary key,
    oDate date,
    oTotalPrice double,
    cId int,
    foreign key(cId) references customer(cId)
);
CREATE TABLE product(
	pId int auto_increment primary key,
    pName varchar(30),
    pPrice double
);
CREATE TABLE order_detail(
	oId int,
    pId int,
    sl_product int,
    primary key(oId,pId),
    foreign key(pId) references product(pId),
    foreign key(oId) references `order`(oId)
);