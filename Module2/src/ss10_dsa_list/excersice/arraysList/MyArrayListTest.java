package ss10_dsa_list.excersice.arraysList;

import com.sun.xml.internal.ws.api.client.WSPortInfo;

import java.util.Arrays;

public class MyArrayListTest {
    public static class Student {
        private int id;
        private String name;

        public Student() {

        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        Student student1 = new Student(1, "duc");
        Student student2 = new Student(2, "dung");
        Student student3 = new Student(3, "duy");
        Student student4 = new Student(4, "nam");
        Student student5 = new Student(5, "huyen");
        Student student6 = new Student(5, "ha");
        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
        MyArrayList<Student> newStudentMyArrayList = new MyArrayList<>();
        studentMyArrayList.add(student1);
        studentMyArrayList.add(student2);
        studentMyArrayList.add(student3);
        studentMyArrayList.add(student4);
        studentMyArrayList.add(2, student5);
        studentMyArrayList.getSize();
//        studentMyArrayList.clear();
        for (int i = 0; i < studentMyArrayList.getSize(); i++) {
            Student student = (Student) studentMyArrayList.elements[i];
            System.out.println(student.getId() + " " + student.getName());
        }
        System.out.println("size " + studentMyArrayList.getSize());
        System.out.println(studentMyArrayList.get(2).getName());
        System.out.println(studentMyArrayList.get(2).getId());
        System.out.println("position---------------------------------------------------");
        System.out.println(" vi tri " + studentMyArrayList.indexOf(student3));
        System.out.println("contains---------------------------------------------------");
        System.out.println(studentMyArrayList.contains(student6));
        System.out.println("Clone---------------------------------------------------");
        newStudentMyArrayList =studentMyArrayList.clone();
        for (int i = 0; i <newStudentMyArrayList.getSize() ; i++) {
            System.out.println(newStudentMyArrayList.get(i).getName());
        }
        System.out.println("Remove---------------------------------------------------");
        Student student = newStudentMyArrayList.remove(2);
        System.out.println(student.getName());
    }
}

