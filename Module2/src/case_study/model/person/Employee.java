package case_study.model.person;

public class Employee extends Person {
    private String location;
    private String level;
    private double salary;
    public Employee(){

    }

    public Employee(double id, String name, String gender, String date, double identityCardNumber, double phoneNumber, String email, String location, String level, double salary) {
        super(id, name, gender, date, identityCardNumber, phoneNumber, email);
        this.location = location;
        this.level = level;
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return   "Employee: " + super.toString() + "location='" + location + '\'' +
                ", level='" + level + '\'' +
                ", salary=" + salary ;
    }
}
