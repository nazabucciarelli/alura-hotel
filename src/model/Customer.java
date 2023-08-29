package model;

import java.sql.Date;

public class Customer {
    private Long id;
    private String name;
    private String lastname;
    private Date birthDate;
    private String nacionality;
    private String phoneNumber;
    private long bookingId;

    public Customer(Long id, String name, String lastname, Date birthDate, String nacionality, String phoneNumber, long bookingId) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.nacionality = nacionality;
        this.phoneNumber = phoneNumber;
        this.bookingId = bookingId;
    }

    public Customer(String name, String lastname, Date birthDate, String nacionality, String phoneNumber, long bookingId) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.nacionality = nacionality;
        this.phoneNumber = phoneNumber;
        this.bookingId = bookingId;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }
}
