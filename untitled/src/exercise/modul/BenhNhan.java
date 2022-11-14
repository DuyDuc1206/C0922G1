package exercise.modul;

public class BenhNhan extends Person {
    private String date;
    private String hanVip;

    public BenhNhan() {
    }
    public BenhNhan(String id, String name ,String hanVip){
        super(id,name);
        this.hanVip = hanVip;
    }

    public BenhNhan(String id, String name, String gender, String date, String hanVip) {
        super(id, name, gender);
        this.date = date;
        this.hanVip = hanVip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHanVip() {
        return hanVip;
    }

    public void setHanVip(String hanVip) {
        this.hanVip = hanVip;
    }

    @Override
    public String toString() {
        return super.toString()+ "BenhNhan{" +
                "date='" + date + '\'' +
                ", hanVip='" + hanVip + '\'' +
                '}';
    }
}
