package services;

import beans.AffectationCours;
import beans.Cours;
import beans.Professeur;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AffectationCoursService implements IDao<AffectationCours> {

    private Connexion connexion;
    private CoursService cs;
    private ProfesseurService pfs;

    public AffectationCoursService() {
        connexion = Connexion.getInstance();
        cs = new CoursService();
        pfs = new ProfesseurService();
    }

    @Override
    public boolean create(AffectationCours o) {
        String req = "INSERT INTO AffectationCours (professeur_id, cours_id) VALUES (?, ?)"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getProfesseur().getId());
            ps.setInt(2, o.getCours().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'insertion : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(AffectationCours o) {
        String req = "DELETE FROM AffectationCours WHERE professeur_id = ? AND cours_id = ?"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getProfesseur().getId());
            ps.setInt(2, o.getCours().getId()); 
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(AffectationCours o) {
        String req = "UPDATE AffectationCours SET professeur_id = ?, cours_id = ? WHERE professeur_id = ? AND cours_id = ?"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getProfesseur().getId());
            ps.setInt(2, o.getCours().getId());
            ps.setInt(3, o.getProfesseur().getId());
            ps.setInt(4, o.getCours().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour : " + ex.getMessage());
        }
        return false;
    }

    public AffectationCours findById(int profId, int courId) {
        String req = "SELECT * FROM AffectationCours WHERE professeur_id = ? AND cours_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, profId);
            ps.setInt(2, courId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Professeur professeur_id = pfs.findById(profId);
                Cours cours_id = cs.findById(courId);
                return new AffectationCours(professeur_id, cours_id);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<AffectationCours> findAll() {
        List<AffectationCours> affectationCours = new ArrayList<>();
        String req = "SELECT * FROM AffectationCours"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                Professeur professeur_id = pfs.findById(rs.getInt("professeur_id"));
                Cours cours_id = cs.findById(rs.getInt("cours_id")); 
                affectationCours.add(new AffectationCours(professeur_id, cours_id));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des données : " + ex.getMessage());
        }
        return affectationCours;
    }
    
    public void affecterCours(int professeurId, int coursId) {
        String req = "INSERT INTO AffectationCours (professeur_id, cours_id) VALUES (?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, professeurId);
            ps.setInt(2, coursId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'affectation du cours : " + ex.getMessage());
        }
    }

    @Override
    public AffectationCours findById(int id) {

        String req = "SELECT * FROM AffectationCours WHERE professeur_id = ? OR cours_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Professeur professeur = pfs.findById(id);
                Cours cours = cs.findById(id);
                return new AffectationCours(professeur, cours);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche : " + ex.getMessage());
        }
        return null;    
    }
}
