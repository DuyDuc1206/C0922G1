package ss12_collections_framework.exercise.model;

public class Product {
    private Integer id;
    private String name;
    private Integer price;

    public Product() {

    }

    public Product(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String toString() {
        return "Product:"
                + " ( id:" + getId()
                + " ,name:" + getName()
                + " ,price:" + getPrice() + " )";
    }
}
