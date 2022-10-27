package ss17_io_binary_file_serialization.exercise.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String productName;
    private String productBrand;
    private double price;
    private String otherDescription;

    public Product() {
    }

    public Product(int id, String productName, String productBrand, double price, String otherDescription) {
        this.id = id;
        this.productName = productName;
        this.productBrand = productBrand;
        this.price = price;
        this.otherDescription = otherDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", price=" + price +
                ", otherDescription='" + otherDescription + '\'' +
                '}';
    }
}
