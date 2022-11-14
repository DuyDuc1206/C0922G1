package test_read_write_file.model;

//1. tính kế thừa ở extend
//2. tính đóng gói ở private và getter, setter
//3.tính trừu trượn
//4. tính đa hình
// construcer: đa hình tại compile
//to string : đa hình tại runtime
//Person person = new Student
//person.toString
public class Student extends Person implements Comparable<Student> {
    private double score;

    public Student() {
    }

    public Student(int id, String name, int age, double score) {
        super(id, name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" +
                "score=" + score +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return Double.compare(student.score, score) == 0 &&
//                nameClass.equals(student.nameClass) && this.getName().equals(student.getName());
//    }


    public int compareTo(Student o) {
//        double result = this.getScore() - o.getScore();
//        if( result>0){
//            return 1;
//        }
        if (this.getId() > o.getId()) {
            return 1;
        } else if (this.getId() == o.getId()) {
            return this.getName().compareTo(o.getName());
        } else {
            return -1;
        }
    }
}
