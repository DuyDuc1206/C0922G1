create database ss3_sales_management_database;
drop database ss3_sales_management_database;
use sales_management_database;

-- Thêm data cho customer table
insert into customer 
values 
  (1, 'Minh Quan', 10), 
  (2, 'Ngoc Anh', 20), 
  (3, 'Hong Ha', 50);
  
-- Thêm dât cho order table
insert into `order` 
values 
  (1, '2006-03-21', null, 1), 
  (2, '2006-03-23', null, 2), 
  (3, '2006-03-16', null, 1);
  
-- Thêm data cho procuct table
insert into product 
values 
  (1, 'May Giac', 3), 
  (2, 'Tu Lanh', 5), 
  (3, 'Dieu Hoa', 7), 
  (4, 'Qep Dien', 2);
  
-- Thêm data cho order_detail table
insert into order_detail 
values 
  (1, 1, 3), 
  (1, 3, 7), 
  (1, 4, 2), 
  (2, 1, 1), 
  (3, 1, 8), 
  (1, 2, 4), 
  (2, 3, 3);
  
-- Hiển thị oId, oDate, oPrice trong order table
select 
  o.o_id, 
  o.o_date, 
  ifnull (o.o_total_price, 'chua co gia') 
from 
  `order` as o;
  
-- Hiển thị ds các khách hàng đã mua hàng,và danh sách sản phẩm được mua bởi các khách
select 
  c.c_name, 
  p.p_name 
from 
  customer c 
  inner join `order` o on c.c_id = o.c_id 
  inner join order_detail od on o.o_id = od.o_id 
  inner join product p on p.p_id = od.p_id;
  
-- Hiển thị tên những khách hàng không mua bất kì một sản phẩm nào
select 
  c.c_name 
from 
  customer c 
where 
  c.c_id not in (
    select 
      o.c_id 
    from 
      `order` o
  );
  
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select 
  o.o_id, 
  o.o_date, 
  sum(od.sl_product * p.p_price) as price 
from 
  `order` o 
  inner join order_detail od on o.o_id = od.o_id 
  inner join product p on p.p_id = od.p_id 
group by 
  o.o_id;
