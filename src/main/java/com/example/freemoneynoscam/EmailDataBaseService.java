package com.example.freemoneynoscam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmailDataBaseService {
    public Connection conn;

    public void insertEmailIntoDB(String input) {
        var query = "INSERT INTO email (`email-address`) VALUES (?)";
        executeQuery(query,input);
    }

    public List<String> getAllEmails() {
        var list = new ArrayList<String>();
        var query = "SELECT `email-address` FROM email";


        return list;
    }

    private void executeQuery(String query, String input) {
        try {
            if(conn==null) {
                conn = createServerConnection();
            }

            var psts = conn.prepareStatement(query);
            psts.setString(1, input);
            psts.execute();

        } catch (SQLException e) {
            System.out.println("Cannot connect to database");
            e.printStackTrace();
        }
    }

    private Connection createServerConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/emails","root","miip moop");
    }
}
