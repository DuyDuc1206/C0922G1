create database du_lieu_quan_li_sinh_vien;
use quan_ly_sinh_vien;
insert into class
values 
	(1, 'A1', '2008-12-20', 1),
	(2, 'A2', '2008-12-22', 1),
	(3, 'A3', current_date, 0);
    
insert into student (StudentName, Address, Phone, Status, ClassId)
values
	('Hung', 'Ha Noi', '0912113113', 1, 1),
    ('Hoa', 'da nang', '0912123583', 1, 1),
    ('Manh', 'ho chi minh', '0185123583', 0, 2);
    
insert into `subject`
values
	(1, 'CF', 5, 1),
	(2, 'C', 6, 1),
	(3, 'HDJ', 5, 1),
	(4, 'RDBMS', 10, 1);
    
insert into mark (SubId, StudentId, Mark, ExamTimes)
values 
	(1, 1, 8, 1),
	(1, 2, 10, 2),
	(2, 1, 12, 1);
    
drop database du_lieu_quan_li_sinh_vien;