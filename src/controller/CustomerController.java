package controller;

import dao.CustomerDAO;
import factory.ConnectionFactory;
import model.Customer;

import java.util.List;

public class CustomerController {
    private CustomerDAO customerDAO;

    public CustomerController(){
        this.customerDAO = new CustomerDAO(new ConnectionFactory().getConnection());
    }

    public long save(Customer customer){
        return this.customerDAO.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return this.customerDAO.getAllCustomers();
    }
    public int deleteById(Long id){
        return this.customerDAO.deleteById(id);
    }

    public List<Customer> getByLastname(String param){
        return this.customerDAO.getByLastname(param);
    }

    public List<Customer> getByBookingId(long id) {
        return this.customerDAO.getByBookingId(id);
    }

    public void updateById(Customer newCustomer, long id){
        this.customerDAO.updateById(newCustomer, id);
    }
}
