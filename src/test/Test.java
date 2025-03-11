package test;

import beans.AffectationCours;
import beans.Cour;
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
        
        for(Cour c : cs.findAll())
            cs.delete(c);
        
        for(AffectationCours a : afs.findAll())
            afs.delete(a);
        
        

        pfs.create(new Professeur("ALAMI", "Sara", "Informatique"));
        pfs.create(new Professeur("BENANI", "Bilal", "Mathématiques"));

        cs.create(new Cour("Java", "Salle I1"));
        cs.create(new Cour("Algèbre", "Salle I2"));

        afs.affecterCours(23, 30);
        afs.affecterCours(24, 31);

        List<Professeur> profs = pfs.findByNom("Sara");
        System.out.println("\nProfesseurs trouvés : " + profs);

        List<Professeur> informatiqueProfs = pfs.findBySpecialite("Informatique");
        System.out.println("\nProfesseurs en Informatique : " + informatiqueProfs);
        
        System.out.println("Professeurs :");
        for(Professeur p : pfs.findAll())
            System.out.println(p.getNom() +" "+ p.getPrenom() +" "+ p.getSpecialite());
        
        System.out.println("Cours :");
        for(Cour c : cs.findAll())
            System.out.println(c.getIntitule() +" "+ c.getSalle());
        
        
    }
}
