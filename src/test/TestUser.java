package test;

import controller.UserController;
import model.User;

public class TestUser {
    public static void main(String[] args) {
        UserController userController = new UserController();

        System.out.println(userController.login(new User("admin","admin123")));
    }
}
