package test_read_write_file.model;

public class Teacher extends Person{
    private double salary;

    public Teacher() {
    }

    public Teacher(int id, String name, int age, double salary) {
        super(id, name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "Teacher{" +
                "salary=" + salary +
                '}';
    }
}
