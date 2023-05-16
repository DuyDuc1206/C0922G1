package model.customer;

public class Customer {
    private int id;
    private String customerName;
    private String dateOfBirth;
    private boolean gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    private int customerTypeId;
    private CustomerType customerTypeName;

    public Customer() {
    }

    public Customer(int id, String customerName, String dateOfBirth, boolean gender, String idCard, String phoneNumber, String email, String address, int customerTypeId) {
        this.id = id;
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerTypeId = customerTypeId;
    }

    public Customer(String customerName, String dateOfBirth, boolean gender, String idCard, String phoneNumber, String email, String address, CustomerType customerTypeName) {
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerTypeName = customerTypeName;
    }

    public Customer(String customerName, String dateOfBirth, boolean gender, String idCard, String phoneNumber, String email, String address, int customerTypeId) {
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerTypeId = customerTypeId;
    }

    public Customer(int id, String customerName, String dateOfBirth, boolean gender, String idCard, String phoneNumber, String email, String address, int customerTypeId,CustomerType customerTypeName) {
        this.id = id;
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDOB(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
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

    public void setCustomerType(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public CustomerType getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(CustomerType customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
