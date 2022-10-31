package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestStudent {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(4,"nam",10d));
        studentList.add(new Student(5,"duyen",10d));
        studentList.add(new Student(2,"hi",10d));
        studentList.add(new Student(2,"duong",8.7));
        for (Student student:studentList){
            System.out.println(student.toString());
        }
        System.out.println("Sort by id ascending");
        Collections.sort(studentList,Collections.reverseOrder());
        for (Student student:studentList){
            System.out.println(student.toString());
        }
        System.out.println("Sort by name ascending");
        Collections.sort(studentList, new SortByAge());
        for (Student student:studentList){
            System.out.println(student.toString());
        }
    }
}
