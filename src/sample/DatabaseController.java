package sample;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class DatabaseController {

    private static Connection conn;
    private static PreparedStatement stmt;

    public static boolean setConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e) {
            System.out.print("No JDBC driver found");
            return false;
        };
        try {
            conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/db_muselinked?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","qwerty");
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    };

    public static void logInUser(String _username, String _password) {
        if(_username.matches("\\s") || _password.matches("\\s")){
            System.out.print("Username or password is incorrect");
        }
        else try {
            stmt = conn.prepareStatement("SELECT COUNT(*) as cnt FROM USERS WHERE USERNAME =\'" + _username + "\' AND PASSWORD_ =\'" + _password + "\'");
            ResultSet results = stmt.executeQuery();
            results.next();
            int cnt = results.getInt(1);

            if (cnt == 1) {
                System.out.print("LOGIN OK!");
            } else
                System.out.print("Login or password is incorrect!");

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

}
