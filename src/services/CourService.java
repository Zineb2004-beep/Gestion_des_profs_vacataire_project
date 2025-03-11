package services;

import beans.Cour;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourService implements IDao<Cour> {

    private Connexion connexion;

    public CourService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Cour o) {
        String req = "INSERT INTO Cours (id_Cour ,intitule, salle) VALUES (NULL, ?, ?)"; 
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
    public boolean delete(Cour o) {
        String req = "DELETE FROM Cours WHERE id_Cour = ?";
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
    public boolean update(Cour o) {
        String req = "UPDATE Cours SET intitule = ?, salle = ? WHERE id_Cour = ?";
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
    public Cour findById(int id) {
        String req = "SELECT * FROM Cours WHERE id_Cour = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Cour(rs.getInt("id_Cour"), rs.getString("intitule"), rs.getString("salle"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Cour> findAll() {
        List<Cour> cours = new ArrayList<>();
        String req = "SELECT * FROM Cours";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cours.add(new Cour(rs.getInt("id_Cour"), rs.getString("intitule"), rs.getString("salle")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cours;
    }
}