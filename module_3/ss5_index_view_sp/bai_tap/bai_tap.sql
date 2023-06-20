create database demo;
create table product(
id int primary key auto_increment,
product_code varchar(50),
product_name varchar (50),
product_price double,
product_amount int,
product_description varchar(50),
product_status varchar(50)
);
insert into product (product_code,product_name,product_price,product_amount,product_description,product_status)
values ('SC-001', 'Bánh chocopie',45000,50,'Bánh mềm','Đầy đủ'),
 ('SC-002', 'Bánh chocopie hương dâu',50000,50,'Bánh mềm','còn 10 họp'),
 ('SC-003', 'Bánh chocopie hương dark',55000,50,'Bánh mềm','còn 20 họp');
 
 create unique index index_code on product(product_code);
 create index compisite on product(product_name, product_price);
 explain select*
 from product
 where product_code = 'SC-001' ;
 
 explain select*
 from product 
 where product_name = 'Bánh chocopie hương dark' and product_price = '55000';
 
 create view view_product as 
 select product_code,product_name,product_price,product_status
 from product ;
 
 update view_product
 set product_status = 'bánh đạt chất lượng'
 where product_code = 'SC-003' 
 ;
 
 delete from view_product
 where product_code = 'SC-003';
 
 drop view view_product;
 
delimiter //
create procedure procedure_product ()
begin
 select*
 from product; 
 end //
 delimiter ;
 call procedure_product();
 
 
 delimiter //
 create procedure add_procedure_product(
product_code varchar(50),
 product_name varchar (50),
 product_price double,
 product_amount int,
product_description varchar(50),
 product_status varchar(50))
begin 
insert into product (product_code,product_name,product_price,product_amount,product_description,product_status)
value (product_code,product_name,product_price,product_amount,product_description,product_status);
end //
delimiter ;

delimiter //
drop procedure if exists `update_procedure_product`//
create procedure update_procedure_product(
id int,
product_code varchar(50),
 product_name varchar (50),
 product_price double,
 product_amount int,
product_description varchar(50),
 product_status varchar(50))
begin
update product
set product_code = product_code,
 product_name = product_name,
  product_price  = product_price,
  product_amount =product_amount,
 product_description =product_description,
 product_status =product_status
where product.id = id;
end //
delimiter ;

delimiter //
drop procedure if exists `delete_procedure_product`//
create procedure delete_procedure_product(
id int)
begin
delete from product
where product.id = id
;
end //
delimiter ;