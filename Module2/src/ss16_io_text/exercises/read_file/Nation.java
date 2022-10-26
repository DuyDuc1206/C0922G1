package ss16_io_text.exercises.read_file;

public class Nation {
    private int id;
    private String shortedName;
    private String name;

    public Nation() {
    }

    public Nation(int id, String shortedName, String name) {
        this.id = id;
        this.shortedName = shortedName;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortedName() {
        return shortedName;
    }

    public void setShortedName(String shortedName) {
        this.shortedName = shortedName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
