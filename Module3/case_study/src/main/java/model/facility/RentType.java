package model.facility;

public class RentType {
    private int id;
    private String name;

    public RentType() {
    }

    public RentType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public RentType(String name) {
        this.name = name;
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
}
