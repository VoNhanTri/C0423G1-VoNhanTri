
 select*
from subject
 where Credit in (select max(Credit)
 from subject
 );
 
 
 select s.SubName, m.Mark
 from subject s 
 left join mark m on s.SubId = m.SubId
 where m.Mark in(
 select max(Mark)
 from mark
 )
 order by s.SubName;



SELECT S.StudentId,S.StudentName, S.Address, s.Phone,s.Status,s.ClassId, AVG(Mark) as arrange
FROM Student S 
join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
order by arrange;


