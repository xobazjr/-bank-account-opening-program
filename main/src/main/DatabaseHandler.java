package main;


import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class DatabaseHandler {

    private static final String URL = "jdbc:mysql://localhost:3306/accountdb";
    private static final String USER = "root";
    private static final String PASSWORD = "yourpassword";

    public void saveToDatabase(String id, double money, double bath, double rate, LocalDate openDate, String firstName, String lastName, LocalDate birthDate, int age) {
        String query = "INSERT INTO account_info (account_id, money, bath, annual_interest_rate, open_date, first_name, last_name, birth_date, age) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, id);
            stmt.setDouble(2, money);
            stmt.setDouble(3, bath);
            stmt.setDouble(4, rate);
            stmt.setDate(5, Date.valueOf(openDate));
            stmt.setString(6, firstName);
            stmt.setString(7, lastName);
            stmt.setDate(8, Date.valueOf(birthDate));
            stmt.setInt(9, age);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data saved successfully!");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving data: " + ex.getMessage());
        }
    }
}
