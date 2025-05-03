package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactFacade {

    private static final String JDBC_URL =
        "jdbc:mysql://localhost:3306/" + "Contacts";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public void createContact(
        String firstName,
        String lastName,
        String email,
        String phone,
        String address
    ) {
        String sql =
            "INSERT INTO Contact (FIRSTNAME, LASTNAME, EMAIL, PHONE, ADDRESS) VALUES (?, ?, ?, ?, ?)";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setString(5, address);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> findAll() {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM Contact";
        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                Contact contact = new Contact(
                    rs.getLong("ID_CONTACT"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"),
                    rs.getString("EMAIL"),
                    rs.getString("PHONE"),
                    rs.getString("ADDRESS")
                );
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public void deleteContact(String id) {
        String sql = "DELETE FROM Contact WHERE ID_CONTACT = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setLong(1, Long.parseLong(id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Contact findById(String id) {
        String sql = "SELECT * FROM Contact WHERE ID_CONTACT = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setLong(1, Long.parseLong(id));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Contact(
                    rs.getLong("ID_CONTACT"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"),
                    rs.getString("EMAIL"),
                    rs.getString("PHONE"),
                    rs.getString("ADDRESS")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateContact(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String address
    ) {
        String sql =
            "UPDATE Contact SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, PHONE = ?, ADDRESS = ? WHERE ID_CONTACT = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setString(5, address);
            stmt.setLong(6, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
