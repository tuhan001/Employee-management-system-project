package employee_managment_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conn {

    Connection connection;
    Statement statement;

    public conn() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "tuhan", "9876543210");


            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }
    }


}


