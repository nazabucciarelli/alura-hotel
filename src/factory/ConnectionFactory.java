package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final Connection con;

    public ConnectionFactory(){
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost/alura_hotel?useTimeZone=true&serverTimeZone=UTC",
                    "root","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        return this.con;
    }
}
