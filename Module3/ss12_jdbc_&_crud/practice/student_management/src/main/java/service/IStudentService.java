package service;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAllStudent();
    Student findStudentById(int id);
    List<Student> findStudentByCountry(String country);
    boolean update(Student student);
    boolean insert(Student student);
    boolean delete(int id);
}
