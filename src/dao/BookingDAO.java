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
                try(rs){
                    rs.next();
                    return rs.getLong(1);
                }
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
            try(rs){
                while(rs.next()){
                    fillListOfResult(rs,result);
                }
                return result;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Booking> getById(long booking_id){
        List<Booking> result = new ArrayList<>();
        try{
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM booking WHERE id = ?");
            try(ps){
                ps.setLong(1,booking_id);
                ResultSet rs = ps.executeQuery();
                try(rs){
                    while(rs.next()){
                        fillListOfResult(rs,result);
                    }
                    return  result;
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void fillListOfResult(ResultSet rs, List<Booking> result) throws SQLException {
        long id = rs.getLong("id");
        Date checkInDate =rs.getDate("checkin_date");
        Date checkOutDate = rs.getDate("checkout_date");
        double value = rs.getDouble("value");
        String payMethod = rs.getString("pay_method");
        long userId = rs.getLong("user_id");
        Booking booking = new Booking(id,checkInDate,checkOutDate,value,payMethod,userId);
        result.add(booking);
    }

    public int deleteById(long id){
        try{
            PreparedStatement ps = this.con.prepareStatement("DELETE FROM customer WHERE booking_id=?");
            try(ps){
                ps.setLong(1,id);
                ps.executeUpdate();
                PreparedStatement psBooking = this.con.prepareStatement("DELETE FROM booking WHERE id=?");
                try(psBooking){
                    psBooking.setLong(1,id);
                    return psBooking.executeUpdate();
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateById(Booking newBooking, long id) {
        try{
            PreparedStatement ps = this.con.prepareStatement("UPDATE booking SET checkin_date=?,checkout_date=?,value=?," +
                    "pay_method=? WHERE id=?");
            try(ps){
                ps.setDate(1,newBooking.getCheckInDate());
                ps.setDate(2,newBooking.getCheckOutDate());
                ps.setDouble(3,newBooking.getValue());
                ps.setString(4,newBooking.getPayMethod());
                ps.setLong(5,id);
                ps.executeUpdate();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
