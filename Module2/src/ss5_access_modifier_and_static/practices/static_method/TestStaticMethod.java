package ss5_access_modifier_and_static.practices.static_method;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        System.out.println(Student.college);
        Student student1 = new Student("DUC", 24);
        Student student2 = new Student("DUC1", 25);
        Student student3 = new Student("DUC2", 26);
        student1.display();
        student2.display();
        student3.display();
    }
}
