create table product(
id int primary key auto_increment,
name varchar(100) not null,
price double not null,
status varchar(300),
producer varchar(300)
);
insert into product(name,price,status,producer)
values("banh",15000,"banh chocolate","Orion"),
("keo",10000,"keo chocolate","Orion"),
("snack",5000,"snack chocolate","Orion");
