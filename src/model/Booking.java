package model;

import java.sql.Date;

public class Booking {
    private Long id;
    private Date checkInDate;
    private Date checkOutDate;
    private double value;
    private String payMethod;
    private Long user_id;

    public Booking(Long id, Date checkInDate, Date checkOutDate, double value, String payMethod,long user_id) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.value = value;
        this.payMethod = payMethod;
    }

    public Booking(Date checkInDate, Date checkOutDate, double value, String payMethod, long user_id) { // Constructor to show the object Booking
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.value = value;
        this.payMethod = payMethod;
        this.user_id = user_id;
    }

    public Booking(Date checkinDate, Date checkoutDate, double value, String payMethod) { // Constructor to modify the record
        this.checkInDate = checkinDate;
        this.checkOutDate = checkoutDate;
        this.value = value;
        this.payMethod = payMethod;
    }


    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
