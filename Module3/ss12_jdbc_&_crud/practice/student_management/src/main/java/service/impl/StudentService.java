package service.impl;

import model.Student;
import repository.IStudentRepository;
import repository.impl.StudentRepository;
import service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAllStudent();
    }

    @Override
    public Student findStudentById(int id) {
        return null;
    }

    @Override
    public List<Student> findStudentByCountry(String country) {
        return studentRepository.findStudentByCountry(country);
    }

    @Override
    public boolean update(Student student) {
        return studentRepository.update(student);
    }

    @Override
    public boolean insert(Student student) {
        return studentRepository.insert(student);
    }

    @Override
    public boolean delete(int id) {
        return studentRepository.delete(id);
    }
}
