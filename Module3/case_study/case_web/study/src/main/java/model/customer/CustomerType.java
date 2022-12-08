package model.customer;

public class CustomerType {
    private int id;
    private String customerTypeName;

    public CustomerType() {
    }

    public CustomerType(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public CustomerType(int id, String customerTypeName) {
        this.id = id;
        this.customerTypeName = customerTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
