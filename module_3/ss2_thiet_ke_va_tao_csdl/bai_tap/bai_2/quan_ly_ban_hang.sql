create database quan_ly_ban_hang;
drop table `order`;
create table customer(
c_id varchar(20) primary key,
customer_name varchar(45),
customer_age int
);
create table `order`(
o_id varchar(20) primary key,
customer_id varchar(20),
order_date date,
order_total_price int,
foreign key (customer_id) references customer(c_id)
);
create table product(
p_id varchar(45) primary key,
p_name varchar(45),
p_price int
);
create table order_detail(
order_id varchar(20),
product_id varchar(45),
od_QTY date,
foreign key (order_id) references `order`(o_id),
foreign key (product_id) references product(p_id)
);
alter table order_detail
add constraint pk_order primary key (order_id, product_id);