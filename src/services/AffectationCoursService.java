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
    private CourService cs;
    private ProfesseurService pfs;

    public AffectationCoursService() {
        connexion = Connexion.getInstance();
        cs = new CourService();
        pfs = new ProfesseurService();
    }

    @Override
    public boolean create(AffectationCours o) {
        String req = "INSERT INTO AffectationCours (prof_id, cour_id) VALUES (?, ?)"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getProf().getId());
            ps.setInt(2, o.getCour().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'insertion : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(AffectationCours o) {
        String req = "DELETE FROM AffectationCours WHERE cour_id = ? AND prof_id = ?"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getCour().getId()); 
            ps.setInt(2, o.getProf().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(AffectationCours o) {
        String req = "UPDATE AffectationCours SET prof_id = ?, cour_id = ? WHERE prof_id = ? AND cour_id = ?"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getProf().getId());
            ps.setInt(2, o.getCour().getId());
            ps.setInt(3, o.getProf().getId());
            ps.setInt(4, o.getCour().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour : " + ex.getMessage());
        }
        return false;
    }

    public AffectationCours findById(int profId, int courId) {
        String req = "SELECT * FROM AffectationCours WHERE prof_id = ? AND cour_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, profId);
            ps.setInt(2, courId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Professeur prof = pfs.findById(profId);
                Cours cour = cs.findById(courId);
                return new AffectationCours(cour, prof);
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
                Cours cour = cs.findById(rs.getInt("cour_id")); 
                Professeur prof = pfs.findById(rs.getInt("prof_id"));
                affectationCours.add(new AffectationCours(cour, prof));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des données : " + ex.getMessage());
        }
        return affectationCours;
    }
    
    public void affecterCours(int professeurId, int coursId) {
        String req = "INSERT INTO AffectationCours (prof_id, cour_id) VALUES (?, ?)";
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
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
