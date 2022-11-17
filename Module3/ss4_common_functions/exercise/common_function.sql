create database ss4_student_management_database_query;
use quan_ly_sinh_vien;

-- Hiển thị tất cả các thông tin môn học có credit lớn nhất
select * from subject
where Credit = (select max(Credit) from subject);

-- Hiển thị các thông tin môn học có điểm thi cao nhất 
select s.*, m.Mark as 'max point' from subject s
join mark m
on m.SubId = s.SubId
where m.Mark =(select max(Mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm đần
select s.*, avg(m.Mark) as 'average' from student s, mark m
where s.StudentId = m.StudentId
group by StudentId
order by average desc, s.StudentName asc;


