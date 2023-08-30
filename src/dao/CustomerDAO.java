package dao;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private Connection con;

    public CustomerDAO(Connection con){
        this.con = con;
    }

    public long save(Customer customer){
        try{
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO customer(name,lastname,birthDate,nacionality," +
                    "phoneNumber,booking_id) VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            try(ps){
                ps.setString(1,customer.getName());
                ps.setString(2,customer.getLastname());
                ps.setDate(3,customer.getBirthDate());
                ps.setString(4, customer.getNacionality());
                ps.setString(5,customer.getPhoneNumber());
                ps.setLong(6,customer.getBookingId());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                try(rs){
                    rs.next();
                    return rs.getLong(1);
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Customer> getAllCustomers() {
        List<Customer> result = new ArrayList<>();
        try{
            Statement st = this.con.prepareStatement("SELECT * FROM customer");
            try(st){
                ResultSet rs = st.executeQuery("SELECT * FROM customer");
                try(rs){
                    fillListOfResult(result, rs);
                    return result;
                }
            }

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int deleteById(long id){
        try{
            PreparedStatement ps = this.con.prepareStatement("DELETE FROM customer WHERE ID = ?");
            try(ps){
                ps.setLong(1,id);
                ps.executeUpdate();
                return 0;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getByLastname(String input){
        List<Customer> result = new ArrayList<>();
        try{
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM customer WHERE lastname LIKE ?");
            ps.setString(1,input);
            ResultSet rs = ps.executeQuery();
            fillListOfResult(result, rs);
            return result;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void fillListOfResult(List<Customer> result, ResultSet rs) throws SQLException {
        while (rs.next()){
            long id = rs.getLong("id");
            String name = rs.getString("name");
            String lastname = rs.getString("lastname");
            Date birthDate = rs.getDate("birthDate");
            String nacionality = rs.getString("nacionality");
            String phoneNumber = rs.getString("phoneNumber");
            long bookingId = rs.getLong("booking_id");
            result.add(new Customer(id,name,lastname,birthDate,nacionality,phoneNumber,bookingId));
        }
    }

    public List<Customer> getByBookingId(long id) {
        List<Customer> result = new ArrayList<>();
        try{
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM customer WHERE booking_id=?");
            try(ps){
                ps.setLong(1,id);
                ResultSet rs = ps.executeQuery();
                try(rs){
                    fillListOfResult(result,rs);
                    return result;
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateById(Customer newCustomer, long id) {
        try{
            PreparedStatement st = this.con.prepareStatement("UPDATE customer SET name =?, lastname=?,birthDate=?," +
                    "nacionality=?,phoneNumber=? WHERE id=?");
            try(st){
                st.setString(1,newCustomer.getName());
                st.setString(2,newCustomer.getLastname());
                st.setDate(3,newCustomer.getBirthDate());
                st.setString(4,newCustomer.getNacionality());
                st.setString(5,newCustomer.getPhoneNumber());
                st.setLong(6,id);
                st.executeUpdate();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
