package ss10_dsa_list.excersice.arraysLinkedList;

import ss7_abstract_and_interface.excersice.system_of_geometric_objects.ShapeTest;

public class MyLinkedListTest {
    public static void main(String[] args) {
        class Student{
            private int id;
            private String name;

            public Student(){

            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1,"duc");
        Student student2 = new Student(2,"duy");
        Student student3 = new Student(3,"nguyen");
        Student student4 = new Student(4,"hung");
        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addLast(student3);
        myLinkedList.add(1,student4);
        System.out.println("So phan tu: " + myLinkedList.size());
        for (int i = 0; i <myLinkedList.size() ; i++) {
            Student student =(Student) myLinkedList.get(i);
            System.out.println(student.getName());
        }
        myLinkedList.remove(2);
        System.out.println("sau khi remove");
        for (int i = 0; i <myLinkedList.size() ; i++) {
            Student student =(Student) myLinkedList.get(i);
            System.out.println(student.getName());
        }
    }
}
