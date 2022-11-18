create database product_database;
use product_database;

create table products(
	id int auto_increment primary key,
    product_code int ,
    product_name varchar(50),
    product_price double,
    product_amount int,
    product_description varchar(50),
    product_status varchar(50)
);

insert into products 
values 
	(1,1,'a',2.5,8,'dien thoai','nho'),
	(null,2,'b',5,8,'may tinh','to'),
	(null,3,'c',2.5,8,'quat','lon'),
	(null,4,'d',5.6,8,'ban','go'),
	(null,5,'e',2.5,8,'may giac','new'),
	(null,6,'f',6,8,'xe','old');
    
-- Index
			-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)   
alter table products add index uidx_product_name(product_code);

			-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
alter table products add index cidx_procduct_name(product_name,product_price);

			-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select *from products where product_code = 1;
explain select *from products where product_name = 'c';

-- View
			-- Tao view
create view w_product as 
select product_code, product_name, product_price,product_status from products;
			-- Cap nhat view
create or replace view w_product as
select product_code,product_name, product_description from products where product_code = 1;
			-- Hien thi view
select * from w_product;
			-- Xoa view
drop view w_product;

-- Tạo stored procedure
			-- Tạo stored procedure lấy thông tin
delimiter //
create procedure sp_product()
begin
select * from products;
end //
delimiter ;
call sp_product;

			-- Tao stored procedure them moi san pham
delimiter //
create procedure sp_add_product(in new_id int, new_code int ,new_name varchar(50),new_price double, new_amount int, new_description varchar(50), new_status varchar(50))
begin
insert into products values (new_id, new_code,new_name,new_price, new_amount, new_description, new_status) ;
end //
delimiter ;
call sp_add_product(9,7,'fdsdfd',7,8,'xeaaa','oldaaa');
call sp_product;

			-- Tao stored procedure sửa thông tin sản phẩm theo id
            drop procedure sp_edit_product;
delimiter //
create procedure sp_edit_product(in id_edit int,amount_edit int )
begin 
update products set product_amount = amount_edit where id = id_edit; 
end //
delimiter ;
call sp_edit_product(6,20);
call sp_product;
			-- Tạo stored procedure xóa sản phẩm theo id
delimiter //
create procedure sp_delete_product( in id_delete int)
begin 
delete from products where id = id_delete;
end //
delimiter ;
call sp_delete_product(4);
call sp_product;

drop database product_database;