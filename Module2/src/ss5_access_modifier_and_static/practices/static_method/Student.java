package ss5_access_modifier_and_static.practices.static_method;

public class Student {
    private String name;
    private int age;
    public static String college = "Bach Khoa University";

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static void change(){
        college = "CodeGym";
    }
    void display(){
        System.out.println(this.age + " " + this.name + " " + college);
    }
}
