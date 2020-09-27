package baseapp;

import javax.swing.*;
import java.sql.*;

public class LogAuth {

    public static String authenticate(String username, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://" +
                    "localhost\\SQL_Piotrek:24573;databaseName=Piotrek;" + "user=" + username + ";password=" + password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT USER_NAME() as kolumna");
            if (rs.next()) {
                return rs.getString("kolumna");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}