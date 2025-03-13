package test;

import beans.AffectationCours;
import beans.Cours;
import beans.Professeur;
import services.AffectationCoursService;
import services.CoursService;
import services.ProfesseurService;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        ProfesseurService pfs = new ProfesseurService();
        CoursService cs = new CoursService();
        AffectationCoursService afs = new AffectationCoursService();

        //Suppression des données existantes :
        for (Professeur p : pfs.findAll()) {
            pfs.delete(p);
        }
        for (Cours c : cs.findAll()) {
            cs.delete(c);
        }
        for (AffectationCours a : afs.findAll()) {
            afs.delete(a);
        }

        //Création des professeurs et des cours :
        Professeur p1 = new Professeur("ALAMI", "Sara", "Informatique");
        Professeur p2 = new Professeur("BENANI", "Bilal", "Mathématiques");
        pfs.create(p1);
        pfs.create(p2);

        Cours c1 = new Cours("Java", "salle I1");
        Cours c2 = new Cours("Algèbre", "salle I2");
        cs.create(c1);
        cs.create(c2);

        //Affectation des cours aux professeurs :
        afs.affecterCours(p1.getId(), c2.getId());
        afs.affecterCours(p2.getId(), c1.getId());

        //Mise à jour des données :
        p1.setSpecialite("Economie");
        pfs.update(p1);

        c1.setSalle("salle I3");
        cs.update(c1);

        List<Professeur> professeurs = pfs.findAll();
        List<Cours> coursList = cs.findAll();

        System.out.println("Affichage des données :");

        System.out.println("Professeurs :");
        for (Professeur p : professeurs) {
            System.out.println("- " + p.getNom() + " " + p.getPrenom() + " (" + p.getSpecialite() + ")");
        }

        System.out.println("Cours :");
        for (Cours c : coursList) {
            System.out.println("- " + c.getIntitule() + " (" + c.getSalle() + ")");
        }

        System.out.println("Affectations :");
        List<AffectationCours> affectations = afs.findAll();
        for (AffectationCours a : affectations) {
            System.out.println("- " + a);
        }

        //Rechercher un professeur par id:
        Professeur prof;
        prof = pfs.findById(47);
        System.out.println("\nProfesseur trouvés avec ID 47 est : \n " + "- " + prof.getNom() + " " + prof.getPrenom() + " (" + prof.getSpecialite() + ")");

        //Rechercher un cour par id:
        Cours c;
        c = cs.findById(48);
        System.out.println("\nCour trouvés avec ID 48 est : \n " + "- " + c.getIntitule() + " " + " (" + c.getSalle() + ")");

        //Rechercher un professeur par nom:
        List<Professeur> profs = pfs.findByNom("ALAMI");
        for (Professeur p : profs) {
            System.out.println("\nProfesseurs trouvés avec le nom ALAMI : \n " + "- " + p.getNom() + " " + p.getPrenom() + " (" + p.getSpecialite() + ")");
        }

        //Filtrer par spécialité:
        List<Professeur> mathProfs = pfs.findBySpecialite("Mathématique");
        for (Professeur p : mathProfs) {
            System.out.println("\nProfesseurs trouvés avec la spécialité mathématique : \n " + "- " + p.getNom() + " " + p.getPrenom());
        }

    }
}
