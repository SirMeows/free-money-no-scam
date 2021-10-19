package com.example.freemoneynoscam;

import java.sql.*;

public class EmailDataBaseService {

    public void insertEmailIntoDB(String input) {
        var email = new Email(input);
        if(email.isValidEmail()) {

            try {
                var conn = createServerConnection();
                var psts = conn.prepareStatement("INSERT INTO email ('email-address') VALUES(input)");
                psts.execute();

            } catch (SQLException e) {
                System.out.println("Cannot connect to database");
                e.printStackTrace();
            }
        }
    }

    private Connection createServerConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/emails","root","_FIFIfufu!495");
    }
}
