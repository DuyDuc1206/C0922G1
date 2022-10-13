package ss5_access_modifier_and_static.excercises.layer_in_java;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the class name: ");
//        String className = scanner.nextLine();
//        student.setClassName(className);
//        System.out.print("Enter the name: ");
//        String name = scanner.nextLine();
//        student.setName(name);
        System.out.println("Class's name: " + student.getName());
        System.out.println("Student's name: " + student.getClassName());

    }
}