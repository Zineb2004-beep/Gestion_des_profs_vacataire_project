package services;

import beans.Cours;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursService implements IDao<Cours> {

    private Connexion connexion;

    public CoursService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Cours o) {
        String req = "INSERT INTO Cours (id ,intitule, salle) VALUES (NULL, ?, ?)"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getIntitule());
            ps.setString(2, o.getSalle());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Cours o) {
        String req = "DELETE FROM Cours WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Cours o) {
        String req = "UPDATE Cours SET intitule = ?, salle = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getIntitule());
            ps.setString(2, o.getSalle());
            ps.setInt(3, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Cours findById(int id) {
        String req = "SELECT * FROM Cours WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Cours(rs.getInt("id"), rs.getString("intitule"), rs.getString("salle"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Cours> findAll() {
        List<Cours> cours = new ArrayList<>();
        String req = "SELECT * FROM Cours";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cours.add(new Cours(rs.getInt("id"), rs.getString("intitule"), rs.getString("salle")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cours;
    }
}