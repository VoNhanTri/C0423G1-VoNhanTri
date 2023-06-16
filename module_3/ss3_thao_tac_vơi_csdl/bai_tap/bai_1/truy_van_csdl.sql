USE Quan_Ly_Sinh_Vien;

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select*
from student
where StudentName like "h%";

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select*
from class
where month(startdate) =12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select *
from subject
where Credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
select*
from student
where StudentName ="hung";
set sql_safe_updates = 0;
set sql_safe_updates = 1;
update student
set ClassId = 2
where StudentName = "hung";

-- Hiển thị các thông tin: StudentName, SubName, Mark.
--  Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.

select m.Mark, s.StudentName, sub.SubName
from Mark m
join Student s on m.StudentId = s.StudentId
join subject sub on m.subid = sub.subid
order by Mark desc;
 