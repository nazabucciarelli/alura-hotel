package controller;

import dao.UserDAO;
import factory.ConnectionFactory;
import model.User;

import java.sql.Connection;

public class UserController {
    private UserDAO userDAO;

    public UserController(){
        this.userDAO = new UserDAO(new ConnectionFactory().getConnection());
    }

    public long login(User user){
        return this.userDAO.isUserCorrect(user);
    }
}
