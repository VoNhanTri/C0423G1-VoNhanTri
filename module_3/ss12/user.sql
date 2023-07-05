create table users(
id  int primary key AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120)
);
insert into users(name,email,country)
values("tri","tri@gmail.com","viet nam"),("quy","quy@gmail.com","viet nam");
insert into users(name,email,country)
values("a","aaa","lao");