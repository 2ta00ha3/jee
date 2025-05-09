package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import domain.Etudiant;

public class EtudiantDaoMySQL implements IEtudiantDao {
    @Override
    public void add(Etudiant e) {
        String req = "INSERT INTO etudiants (code, nom, ville, age) VALUES (?, ?, ?, ?)";
        try (Connection cnx = ConnectionFactory.getConnection();
             PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setString(1, e.getCode());
            ps.setString(2, e.getNom());
            ps.setString(3, e.getVille());
            ps.setInt(4, e.getAge());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String code) {
        String req = "DELETE FROM etudiants WHERE code = ?";
        try (Connection cnx = ConnectionFactory.getConnection();
             PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setString(1, code);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Etudiant> findAll() {
        String req = "SELECT * FROM etudiants";
        List<Etudiant> etudiantsList = new ArrayList<>();
        try (Connection cnx = ConnectionFactory.getConnection();
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(req)) {
            while (rs.next()) {
                Etudiant e = new Etudiant();
                e.setCode(rs.getString("code"));
                e.setNom(rs.getString("nom"));
                e.setVille(rs.getString("ville"));
                e.setAge(rs.getInt("age"));
                etudiantsList.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return etudiantsList;
    }

    @Override
    public void update(Etudiant e) {
        String req = "UPDATE etudiants SET nom = ?, ville = ?, age = ? WHERE code = ?";
        try (Connection cnx = ConnectionFactory.getConnection();
             PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setString(1, e.getNom());
            ps.setString(2, e.getVille());
            ps.setInt(3, e.getAge());
            ps.setString(4, e.getCode());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Etudiant> findByVille(String v) {
        String req = "SELECT * FROM etudiants WHERE ville = ?";
        List<Etudiant> etudiantsList = new ArrayList<>();
        try (Connection cnx = ConnectionFactory.getConnection();
             PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setString(1, v);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Etudiant e = new Etudiant();
                e.setCode(rs.getString("code"));
                e.setNom(rs.getString("nom"));
                e.setVille(rs.getString("ville"));
                e.setAge(rs.getInt("age"));
                etudiantsList.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return etudiantsList;
    }

    @Override
    public Etudiant findByCode(String c) {
        String req = "SELECT * FROM etudiants WHERE code = ?";
        Etudiant e = null;
        try (Connection cnx = ConnectionFactory.getConnection();
             PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setString(1, c);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e = new Etudiant();
                e.setCode(rs.getString("code"));
                e.setNom(rs.getString("nom"));
                e.setVille(rs.getString("ville"));
                e.setAge(rs.getInt("age"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }
}
