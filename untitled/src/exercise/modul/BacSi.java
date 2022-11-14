package exercise.modul;

public class BacSi extends Person{
    private int year;

    public BacSi() {
    }
    public BacSi(String id, String name){
        super(id,name);
    }

    public BacSi(String id, String name, String gender, int year) {
        super(id, name, gender);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return super.toString()+"BacSi{" +
                "year=" + year +
                '}';
    }
}
