package sample;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class DatabaseController {

    private Connection conn;

    public void setConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e) {
            System.out.print("No JDBC driver found");
        };

        try {
            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/record_and_rate?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","qwerty");
            this.conn = conn;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

}
