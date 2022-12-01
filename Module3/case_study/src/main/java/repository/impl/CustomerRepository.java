package repository.impl;

import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerRepository {

    public static ResultSet getAll(){
        Statement st =;
        ResultSet rs = st.executeQuery("select * from customer");
        return rs;
    }
    public static Customer getCustomer(int ){
        PreparedStatement ps = ;
        ps.setInt(1,cus_id);
        ResultSet rs = ps.executeQuery();
//        Nếu có kết quả trả về 1 dòng
        if(rs.next()){
            Customer customer = new Customer();
            customer.setCus_id(rs.getInt("cus_id"));
            return customer;

        }
    }
    public static int updateCustomer(Customer cus){
        PreparedStatement
    }
    public static int deleteCustomer(int cus_id){
        PreparedStatement ps = conn.prepar;
        ps.setInt(1,cus_id);
        return ps.executeUpdate();
    }
    public static int addCutomer(Customer cus){
        PreparedStatement ps = ;
        ps.setString(1,cus.getCusName);
        return  ps.executeUpdate();
    }
}
