package controller;

import dao.BookingDAO;
import factory.ConnectionFactory;
import model.Booking;

import java.util.List;

public class BookingController {
    private BookingDAO bookingDAO;

    public BookingController(){
        this.bookingDAO = new BookingDAO(new ConnectionFactory().getConnection());
    }

    public long save(Booking booking){
        return this.bookingDAO.save(booking);
    }

    public List<Booking> getAllBookings() {
        return this.bookingDAO.getAllBookings();
    }

    public int deleteById(long id){
        return this.bookingDAO.deleteById(id);
    }

    public List<Booking> getBookingsById(long id){
        return this.bookingDAO.getBookingsById(id);
    }


}
