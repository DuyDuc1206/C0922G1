package repository.customer.impl;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.BaseRepository;
import repository.customer.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String SELECT_CUSTOMER = " select c.customer_id,c.customer_name,c.date_of_birth,c.gender,c.id_card,c.phone_number,c.email,c.address ,ct.customer_type_id, ct.customer_type_name from customer c\n" +
            "    join customer_type as ct on c.customer_type_id = ct.customer_type_id;";
    private static final String SELECT_CUSTOMER_BY_ID = "select c.* , ct.customer_type_name from customer c\n" +
            "    join customer_type as ct on c.customer_type_id = ct.customer_type_id\n" +
            "    where customer_id = ?;";
    private static final String DELETE_CUSTOMER = "delete from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER = "update customer set customer_name = ?,date_of_birth =?, gender = ?, id_card = ?,phone_number = ?, email=?,address = ?,customer_type_id =? where customer_id = ?;";
    private static final String INSERT_INTO_CUSTOMER = "insert into `customer` (customer_name,date_of_birth,gender,id_card,phone_number,email,address,customer_type_id) values\n" +
            " ( ?, ?, ? , ?, ?,?, ?,?);";
    private static final String SELECT_CUSTOMER_BY_CONDITION = "select c.*, ct.customer_type_name from customer c\n" +
            "    join customer_type as ct on c.customer_type_id = ct.customer_type_id\n" +
            "    where customer_name like ? and address like ?;";
    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_CUSTOMER);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                String name = rs.getString("customer_name");
                String DOB = rs.getString("date_of_birth");
                boolean gender = rs.getBoolean("gender");
                String idCard = rs.getString("id_card");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int idType = rs.getInt("customer_type_id");
                String nameType = rs.getString("customer_type_name");
                CustomerType customerType = new CustomerType(nameType);
                Customer customer = new Customer(id, name, DOB, gender, idCard, phoneNumber, email, address, idType, customerType);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            printSQLException(throwables);
        }
        return customerList;
    }

    @Override
    public Customer selectCustomerById(int id) {
        Customer customer = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id1 =rs.getInt("customer_id");
                String name = rs.getString("customer_name");
                String DOB = rs.getString("date_of_birth");
                boolean gender = rs.getBoolean("gender");
                String idCard = rs.getString("id_card");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int idType = rs.getInt("customer_type_id");
                String customerTypeName = rs.getString("customer_type_name");
                CustomerType customerType = new CustomerType(customerTypeName);
                customer = new Customer(id1, name, DOB, gender, idCard, phoneNumber, email, address,idType, customerType);

            }
        } catch (SQLException throwables) {
            printSQLException(throwables);
        }
        return customer;
    }

    @Override
    public List<Customer> selectCustomerByCondition(String name,String address) {
        List<Customer> customerList =new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_CUSTOMER_BY_CONDITION);
            ps.setString(1,"%"+ name+"%" );
            ps.setString(2,"%"+ address+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("customer_id");
                String name1 = rs.getString("customer_name");
                String DOB = rs.getString("date_of_birth");
                boolean gender = rs.getBoolean("gender");
                String idCard = rs.getString("id_card");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address1 =rs.getString("address");
                int idType = rs.getInt("customer_type_id");
                String customerType = rs.getString("customer_type_name");
                CustomerType customerType1 = new CustomerType(customerType);
                Customer customer = new Customer(id,name1,DOB,gender,idCard,phoneNumber,email,address1,idType,customerType1);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            printSQLException(throwables);
        }
        return customerList;
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_INTO_CUSTOMER);
            ps.setString(1,customer.getCustomerName());
            ps.setString(2,customer.getDateOfBirth());
            ps.setBoolean(3,customer.isGender());
            ps.setString(4,customer.getIdCard());
            ps.setString(5,customer.getPhoneNumber());
            ps.setString(6,customer.getEmail());
            ps.setString(7,customer.getAddress());
            ps.setInt(8,customer.getCustomerTypeId());
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            printSQLException(throwables);
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMER);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getDateOfBirth());
            ps.setBoolean(3, customer.isGender());
            ps.setString(4, customer.getIdCard());
            ps.setString(5, customer.getPhoneNumber());
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getAddress());
            ps.setInt(8, customer.getCustomerTypeId());
            ps.setInt(9, customer.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            printSQLException(throwables);
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            printSQLException(throwables);
        }
        return false;
    }

//    Đóng kết nối
    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
