create database student_management_database_query;
use quan_ly_sinh_vien;

-- Hiển thị tât cả sinh viên có tên bắt đầu bằng kí tự 'h'
select student.StudentName from student
where student.StudentName like 'h%';

-- Hiển thị tât cả các thông tin môn học có credit  trong khoảng từ 3-5
select * from `subject`
where Credit between 3 and 5;

-- Hiển thị các thông tin: StudentName,SubName,Mark.Dữ liệu sắp xếp theo điểm thi giảm dần, nếu trùng sắp xếp theo tăng dần
select student.StudentName 'tên',subject.SubName 'môn',mark.Mark 'điểm' from student,mark,subject
order by mark.Mark desc, student.StudentName asc;

-- Thay đổi mã lớp (classId) của sinh viên có tên 'Hung' là 2
Set sql_safe_updates = 0;
update student 
set classId = 2
where StudentName ='Hung';

-- xem thay đổi classId của Hùng
select * from student;

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12
select * from class
where month(StartDate)>11;

-- Hiển thị các thông tin lớp học có thười gian bắt đầu trước năm 2010
select * from class
where year(StartDate) > 2010;
 