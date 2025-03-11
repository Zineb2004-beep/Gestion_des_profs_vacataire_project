package services;

import beans.AffectationCours;
import beans.Professeur;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesseurService implements IDao<Professeur> {

    private Connexion connexion;

    public ProfesseurService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Professeur o) {
        String req = "INSERT INTO Professeur (id_Prof, nom, prenom, specialite) VALUES (NULL, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getSpecialite());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout du professeur : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Professeur o) {
        String req = "DELETE FROM Professeur WHERE id_Prof = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression du professeur : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Professeur o) {
        String req = "UPDATE Professeur SET nom = ?, prenom = ?, specialite = ? WHERE id_Prof = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getSpecialite());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour du professeur : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Professeur findById(int id) {
        String req = "SELECT * FROM Professeur WHERE id_Prof = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Professeur(
                    rs.getInt("id_Prof"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("specialite")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche du professeur : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Professeur> findAll() {
        List<Professeur> professeurs = new ArrayList<>();
        String req = "SELECT * FROM Professeur";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                professeurs.add(new Professeur(
                    rs.getInt("id_Prof"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("specialite")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des professeurs : " + ex.getMessage());
        }
        return professeurs;
    }

    public List<Professeur> findByNom(String nom) {
        List<Professeur> result = new ArrayList<>();
        String req = "SELECT * FROM Professeur WHERE nom LIKE ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, "%" + nom + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Professeur(
                    rs.getInt("id_Prof"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("specialite")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche par nom : " + ex.getMessage());
        }
        return result;
    }

    public List<Professeur> findBySpecialite(String specialite) {
        List<Professeur> resultat = new ArrayList<>();
        String req = "SELECT * FROM Professeur WHERE specialite = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, specialite);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resultat.add(new Professeur(
                    rs.getInt("id_Prof"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("specialite")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors du filtrage par spécialité : " + ex.getMessage());
        }
        return resultat;
    }

    
}
