create database quan_ly_ban_hang;
drop table `order`;
CREATE TABLE customer (
    c_id VARCHAR(20) PRIMARY KEY,
    customer_name VARCHAR(45),
    customer_age INT
);
CREATE TABLE `order` (
    o_id VARCHAR(20) PRIMARY KEY,
    customer_id VARCHAR(20),
    order_date DATE,
    order_total_price INT,
    FOREIGN KEY (customer_id)
        REFERENCES customer (c_id)
);
CREATE TABLE product (
    p_id VARCHAR(45) PRIMARY KEY,
    p_name VARCHAR(45),
    p_price INT
);
CREATE TABLE order_detail (
    order_id VARCHAR(20),
    product_id VARCHAR(45),
    od_QTY DATE,
    FOREIGN KEY (order_id)
        REFERENCES `order` (o_id),
    FOREIGN KEY (product_id)
        REFERENCES product (p_id)
);
alter table order_detail
add constraint pk_order primary key (order_id, product_id);