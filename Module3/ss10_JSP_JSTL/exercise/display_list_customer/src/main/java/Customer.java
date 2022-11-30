import java.time.LocalDate;

public class Customer {
    private String name;
    private String DOB;
    private String address;
    private String img;

    public Customer() {
    }

    public Customer(String name, String DOB, String address, String img) {
        this.name = name;
        this.DOB = DOB;
        this.address = address;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
