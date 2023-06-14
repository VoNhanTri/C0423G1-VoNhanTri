create database student_management1;
 drop table class;
create table students(
id int primary key auto_increment,
 `name` varchar(45), 
 age int,
 country varchar(45));
create table teacher(
id int primary key auto_increment, 
`name` varchar(45),
 age int,
 country varchar(45));
create table class(
id int primary key auto_increment, 
`name` varchar(45));
insert into students
values(1,"Trí",29,"Quảng Ngãi"),(2,"pháp",25,"Huế");
insert into teacher
values (1,'Công',34,'Quảng Nam'); 
select*
from teacher;
set sql_safe_updates = 0;
delete from students
where id = 1;
set sql_safe_updates = 1;
insert into class(name)
values ("C0323G1");
update teacher
set name = "Trung", age = 24
where id = 1;