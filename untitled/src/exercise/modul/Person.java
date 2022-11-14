package exercise.modul;
//1. Tính trừu tượng: abstract class person, extends
//2. Tính đóng gói: proprty ở private và có getter ,setter.class
//3. Tính đa hình :
//        Runtime: ToString
//          complier : comnstructor
//4. Tính kế thừa :
public abstract class Person {
    private String id;
    private String name;
    private String gender;

    public Person() {
    }
    public Person(String id, String name){
        this.id = id;
        this.name = name;
    }

    public Person(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
