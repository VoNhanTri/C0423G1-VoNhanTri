-- 1. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào.
select s.name as "tên học viên", c.name as "tên lớp"
from student s
 join class c
on s.class_id = c.id;

-- 2. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào và cả các bạn đã đăng ký nhưng chưa có lớp học.
select s.name as "tên học viên", c.name as "tên lớp"
from student s
left join class c
on s.class_id = c.id;

-- 4. Lấy thông tin của các học viên tên “Hai” và 'Huynh’.
select *
from student
where name like "%hai" or name like "%huynh";


-- 5. Lấy ra học viên có điểm lớn hơn 5 .
select *
from student
where point > 5;


-- 6. Lấy ra học viên có họ là “nguyen”
select*
from student
where name like "nguyen%";


-- 7. Thông kế số lượng học sinh theo từng loại điểm.
select point, count(*)
from student
group by point;


-- 8 . Thông kế số lượng học sinh theo điểm và điểm phải lớn hơn 5
select point, count(*)
from student
where point >5
group by point;


-- 9. Thông kế số lượng học sinh theo điểm lớn hơn 5 và chỉ hiện thị với số lượng>=2
select point, count(*)
from student
where point >5
group by point
having count(*) >=2;


-- 10. Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp tên học viên theo alphabet.
 select s.name
 from student s
join class c
on s.class_id = c.id
where c.name = "c1121g1"
order by substring_index(s.name," ",-1); 
 
 
 
--  1. Hiện thị danh sách các lớp có học viên theo học và số lượng học viên của mỗi lớp ( yêu cầu viết code ra giấy )
select c.id, c.name, count(*) count_student
from student s
join class c on s.class_id = c.id
group by c.id, c.name;

-- 2. Tính điểm lớn nhất của mỗi các lớp ( yêu cầu viết code ra giấy )

select s.class_id, max(s.point) as point_max
from student s
group by s.class_id;
-- 3. Tình điểm trung bình  của từng lớp ( yêu cầu viết code ra giấy )

select s.class_id, avg(s.point) as point_average
from student s
group by s.class_id;

-- 4. Lấy ra toàn bộ tên và ngày sinh các instructor và student ở CodeGym. ( yêu cầu viết code ra giấy )
select name, birthday
from student
union all
select name, birthday
from instructor;
-- 5. Lấy ra top 3 học viên có điểm cao nhất của trung tâm. ( yêu cầu viết code ra giấy )
select id, name, point
from student
order by point desc
limit 3;
-- 6 Lấy ra các học viên có điểm số là cao nhất của trung tâm. ( yêu cầu viết code ra giấy )
 select id, name, point
from student
order by point desc
limit 1;