package test;

public class Student implements Comparable<Student>{
    private int id;
    private String name;
    private Double age;

    public Student() {
    }

    public Student(int id, String name, Double age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public int compareTo(Student o){
        if(this.getId()>o.getId()){
            return 1;
        } else if ( this.getId()==o.getId()){
            return this.getAge().compareTo(o.getAge()); // this.getAge() - o.getAge()
        }else {
            return -1;
        }
    }
}
