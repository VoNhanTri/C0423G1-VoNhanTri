create database quan_ly_ban_hang;
CREATE TABLE customer (
    c_id int PRIMARY KEY,
    customer_name VARCHAR(25),
    customer_age tinyint
);
CREATE TABLE `order` (
    o_id int PRIMARY KEY,
    customer_id int,
    order_date datetime,
    order_total_price INT,
    FOREIGN KEY (customer_id)
        REFERENCES customer (c_id)
);
CREATE TABLE product (
    p_id int PRIMARY KEY,
    p_name VARCHAR(25),
    p_price INT
);
CREATE TABLE order_detail (
    order_id int,
    product_id int,
    primary key (order_id, product_id),
    od_QTY int,
    FOREIGN KEY (order_id)
        REFERENCES `order` (o_id),
    FOREIGN KEY (product_id)
        REFERENCES product (p_id)
);
