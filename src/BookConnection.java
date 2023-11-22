import java.sql.*;

public class BookConnection {
    Connection connection;
    Statement statement;
    public BookConnection(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tournament","root","root");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
