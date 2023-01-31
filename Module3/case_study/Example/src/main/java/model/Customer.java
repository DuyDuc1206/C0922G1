package model;

public class Customer {
    private int id;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    private int customerTypeId;
    private CustomerType customerTypeName;

    public Customer() {
    }

    public Customer(int id, String name, String dateOfBirth, String gender, String idCard, String phoneNumber, String email, String address, int customerTypeId, CustomerType customerTypeName) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
    }

    public Customer(String name, String dateOfBirth, String gender, String idCard, String phoneNumber, String email, String address, int customerTypeId, CustomerType customerTypeName) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
    }

    public Customer(int id, String name, String dateOfBirth, String gender, String idCard, String phoneNumber, String email, String address, int customerTypeId) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerTypeId = customerTypeId;
    }

    public Customer(String name, String dateOfBirth, String gender, String idCard, String phoneNumber, String email, String address, int customerTypeId) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerTypeId = customerTypeId;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public CustomerType getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(CustomerType customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
