package repository.impl;

import model.Student;
import repository.BaseRepository;
import repository.IStudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentRepository implements IStudentRepository {
    private static final String SELECT_ALL_STUDENT = "select * from student;";
    private static final String SELECT_STUDENT_BY_ID = "select * from student where id =?";
    private static final String SELECT_STUDENT_BY_COUNTRY = "select * from student where country like ?";
    private static final String DELETE_STUDENT = "delete from student where id = ?;";
    private static final String UPDATE_STUDENT = "update student set name = ?,email= ?, country =? where id = ?;";
    private static final String INSERT_STUDENT = "insert into student (name,email,country) values (?,?,?);";
    private static final String SELECT_STUDENT_BY_PROCEDURE = "call p_select;";
    private static final String DELETE_STUDENT_BY_PROCEDURE = "call p_delete(?);";
    private static final String UPDATE_STUDENT_BY_PROCEDURE = "call p_edit(?,?,?,?);";

    public List<Student> findAllStudent() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement cs = connection.prepareCall(SELECT_STUDENT_BY_PROCEDURE);
//            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_STUDENT);
//            ResultSet rs = ps.executeQuery();
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gmail = rs.getString("email");
                String country = rs.getString("country");
                Student student = new Student(id, name, gmail, country);
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student findStudentById(int id) {
        Student student = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            ps.setInt(1, id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String gmail = rs.getString("gmail");
                String country = rs.getString("country");
                student = new Student(name, gmail, country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findStudentByCountry(String country) {
        List<Student> studentList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_STUDENT_BY_COUNTRY);
            ps.setString(1, "%"+country+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String gmail = rs.getString("email");
                String country1 = rs.getString("country");
                studentList.add(new Student(name, gmail, country1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    @Override
    public boolean update(Student student) {
    Connection connection =BaseRepository.getConnection();
        try {
            CallableStatement cs = connection.prepareCall(UPDATE_STUDENT_BY_PROCEDURE);
            cs.setString(1,student.getName());
            cs.setString(2,student.getGmail());
            cs.setString(3,student.getCountry());
            cs.setInt(4,student.getId());
            return cs.executeUpdate() > 0;
//            PreparedStatement ps = connection.prepareStatement(UPDATE_STUDENT);
//            ps.setString(1,student.getName());
//            ps.setString(2,student.getGmail());
//            ps.setString(3,student.getCountry());
//            ps.setInt(4,student.getId());
//            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false ;
    }

    @Override
    public boolean insert(Student student) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT);
            ps.setString(1,student.getName());
            ps.setString(2,student.getGmail());
            ps.setString(3,student.getCountry());
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement cs = connection.prepareCall(DELETE_STUDENT_BY_PROCEDURE);
            cs.setInt(1,id);
            return cs.executeUpdate() > 0;
//            PreparedStatement ps = connection.prepareStatement(DELETE_STUDENT);
//            ps.setInt(1,id);
//            return ps.executeUpdate() >0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
