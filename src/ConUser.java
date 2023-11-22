import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ConUser {

    Connection connection;
    Statement statement;
    public ConUser(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tournament","root","root");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static Connection mycon() {
        Connection con=null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tournament", "root", "root");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}

