package ss5_access_modifier_and_static.excercises.layer_in_java;

public class Student {
    private String name = "Join";
    private String classes = "C08";

    public Student() {
    }

//    public Student(String name, String classes) {
//        this.name = name;
//        this.classes = classes;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassName(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return classes;
    }
}
