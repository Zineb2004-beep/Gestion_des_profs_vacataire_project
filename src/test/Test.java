package test;

import beans.AffectationCours;
import beans.Cours;
import beans.Professeur;
import services.AffectationCoursService;
import services.CourService;
import services.ProfesseurService;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        
        ProfesseurService pfs = new ProfesseurService();
        CourService cs = new CourService();
        AffectationCoursService afs = new AffectationCoursService();
        
        for(Professeur p : pfs.findAll())
            pfs.delete(p);
        
        for(Cours c : cs.findAll())
            cs.delete(c);
        
        for(AffectationCours a : afs.findAll())
            afs.delete(a);
        
        

        pfs.create(new Professeur("ALAMI", "Sara", "Informatique"));
        pfs.create(new Professeur("BENANI", "Bilal", "Mathématiques"));

        cs.create(new Cours("Java", "Salle I1"));
        cs.create(new Cours("Algèbre", "Salle I2"));

        afs.affecterCours(1, 1);
        afs.affecterCours(2, 1);
        
        
         
        Professeur pu = pfs.findById(35); 
        if (pu != null) {
            pu.setSpecialite("Economie"); 
            pfs.update(pu);
        }

        Cours cu = cs.findById(42); 
        if (cu != null) {
            cu.setSalle("Salle I3");
            cs.update(cu);
        }

        AffectationCours au = afs.findById(35, 42); 
        if (au != null) {
            au.setProf(pfs.findById(36)); 
            afs.update(au);
        }

        List<Professeur> profs = pfs.findByNom("ALAMI");
        System.out.println("\nProfesseurs trouvés : " + profs);

        List<Professeur> informatiqueProfs = pfs.findBySpecialite("Informatique");
        System.out.println("\nProfesseurs en Informatique : " + informatiqueProfs);
        
        List<Professeur> mathProfs = pfs.findBySpecialite("Mathématiques");
        System.out.println("\nProfesseurs en Mathématiques : " + mathProfs);
        
        List<Professeur> ecoProfs = pfs.findBySpecialite("Economie");
        System.out.println("\nProfesseurs en Economie : " + ecoProfs);
        
        System.out.println("Professeurs :");
        for(Professeur p : pfs.findAll())
            System.out.println(p.getNom() +" "+ p.getPrenom() +" "+ p.getSpecialite());
        
        System.out.println("Cours :");
        for(Cours c : cs.findAll())
            System.out.println(c.getIntitule() +" "+ c.getSalle());
        
        
    }
}
