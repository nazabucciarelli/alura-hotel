package dao;

import factory.ConnectionFactory;
import model.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private final Connection con;

    public BookingDAO(Connection con){
        this.con = new ConnectionFactory().getConnection();
    }

    public long save(Booking booking){
        try{
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO booking(checkin_date,checkout_date,value," +
                    "pay_method,user_id) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            try(ps){
                ps.setDate(1,booking.getCheckInDate());
                ps.setDate(2,booking.getCheckOutDate());
                ps.setDouble(3,booking.getValue());
                ps.setString(4,booking.getPayMethod());
                ps.setLong(5,booking.getUser_id());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getLong(1);
            }
        } catch(SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public List<Booking> getAllBookings(){
        List<Booking> result = new ArrayList<>();
        try{
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM booking");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long id = rs.getLong("id");
                Date checkInDate =rs.getDate("checkin_date");
                Date checkOutDate = rs.getDate("checkout_date");
                double value = rs.getDouble("value");
                String payMethod = rs.getString("pay_method");
                long userId = rs.getLong("user_id");
                Booking booking = new Booking(id,checkInDate,checkOutDate,value,payMethod,userId);
                result.add(booking);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return result;
    }

    public long getBookingLastId(){
        try{
            PreparedStatement ps = con.prepareStatement("SELECT MAX(id) FROM booking");
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}