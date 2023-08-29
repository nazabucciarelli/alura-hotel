package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private final Connection con;

    public UserDAO(Connection con){
        this.con = con;
    }

    public void save(User user){
        try{
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO users(username,password) VALUES (?,?)");
            try(ps){
                ps.setString(1,user.getUsername());
                ps.setString(2,user.getPassword());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long isUserCorrect(User user){ // Returns a number greater than 0 if is true.
        try{
            PreparedStatement ps = this.con.prepareStatement("SELECT id,username,password FROM users WHERE username = ?");
            try(ps){
                ps.setString(1,user.getUsername());
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    String password = rs.getString("password");
                    long id = rs.getLong("id");
                    if (user.getPassword().equals(password)){
                        return id;
                    };
                }
                return 0;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
