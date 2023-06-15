create database Furama;
create table job_position(
id_position int primary key,
name_position varchar(45)
);
create table level(
id_level int primary key,
name_level varchar(45)
);
create table part(
id_part int primary key,
name_part varchar(45)
);
create table staff(
id_staff int primary key,
name_staff varchar(45) not null,
date date not null,
identity_staff varchar(45) not null,
salary_staff double not null,
number_phone_staff varchar(45) not null,
email_staff varchar(45),
dress_staff varchar(45),
id_position int,
id_level int,
id_part int,
foreign key (id_position) references job_position(id_position),
foreign key (id_level) references level(id_level),
foreign key (id_part) references part(id_part)
);
create table customer_type(
id_type_customer int primary key,
name_type_customer varchar(45)
);
create table customer(
id_customer int primary key,
id_type_customer int,
foreign key (id_type_customer) references customer_type(id_type_customer),
name_customer varchar(45) not null,
date_customer date not null,
gender_customer bit not null,
identity_customer varchar(45) not null,
number_phone_customer varchar(45) not null,
email_customer varchar(45),
dress_customer varchar(45)
);
create table rental_type(
id_rental_type int primary key,
name_rental_type varchar(45)
);
create table type_service(
id_type_service int primary key,
name_type_service varchar(45)
);
create table service(
id_service int primary key,
name_service varchar(45) not null,
area_service int,
expense_service double not null,
maximum_service int,
id_rental_type int,
id_type_service int,
foreign key (id_rental_type) references rental_type(id_rental_type),
foreign key (id_type_service) references type_service(id_type_service),
room_standart varchar(45),
describe_service varchar(45),
area_pool double,
floors int
);
create table contract(
id_contract int primary key,
date_contract datetime not null,
date_end datetime not null,
deposits double not null,
id_staff int,
id_customer int,
id_service int,
foreign key (id_staff) references staff(id_staff),
foreign key (id_customer) references customer(id_customer),
foreign key (id_service) references service(id_service)
);
create table accompanied_service(
id_accompanied_service int primary key,
name_accomanied_service varchar(45),
price double not null,
unit varchar(10) not null,
status varchar(45)
);
create table contract_detailed(
id_contract_detailed int primary key,
id_contract int,
id_accompanied_service int,
foreign key (id_contract) references contract(id_contract),
foreign key (id_accompanied_service) references accompanied_service(id_accompanied_service)
);