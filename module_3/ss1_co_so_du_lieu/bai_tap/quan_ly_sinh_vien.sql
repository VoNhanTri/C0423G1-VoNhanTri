create database student_management1;
 drop table students;
create table students(
id int primary key auto_increment,
 `name` varchar(45), 
 age int,
 country varchar(45),
 class_id int,
 foreign key (class_id) references class(id)
 );
 create table account_jame(
 `account` varchar(45) primary key,
 `password` varchar(45),
 student_id int,
 foreign key (student_id) references students(id)
 );
create table teacher(
id int primary key auto_increment, 
`name` varchar(45),
 age int,
 country varchar(45));
create table class(
id int primary key auto_increment, 
`name` varchar(45));
create table assignment(
teacher_id int,
class_id int,
assignment datetime,
foreign key (teacher_id) references teacher(id),
foreign key (class_id) references class(id)
);
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