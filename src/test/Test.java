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
        for (Professeur p : pfs.findAll()) pfs.delete(p);
        for (Cours c : cs.findAll()) cs.delete(c);
        for (AffectationCours a : afs.findAll()) afs.delete(a);

        //Création des professeurs et des cours :
        pfs.create(new Professeur("ALAMI", "Sara", "Informatique"));
        pfs.create(new Professeur("BENANI", "Bilal", "Mathématiques"));

        cs.create(new Cours("Java", "salle I1"));
        cs.create(new Cours("Algèbre", "salle I2"));

       // Récupérer les objets après insertion pour obtenir leurs IDs corrects
        List<Professeur> professeurs = pfs.findAll();
        List<Cours> coursList = cs.findAll();

        if (professeurs.size() >= 2 && coursList.size() >= 2) {
            Professeur p1 = professeurs.get(0);
            Professeur p2 = professeurs.get(1);
            Cours c1 = coursList.get(0);
            Cours c2 = coursList.get(1);

            //Affectation des cours aux professeurs :
            afs.affecterCours(p1.getId(), c2.getId());
            afs.affecterCours(p2.getId(), c1.getId());

            //Mise à jour des données :
            p1.setSpecialite("Economie");
            pfs.update(p1);

            c1.setSalle("salle I3");
            cs.update(c1);
        } else {
            System.out.println("Erreur : Impossible de récupérer les professeurs ou les cours.");
        }


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
        
        //Rechercher un professeur par nom:
        List<Professeur> profs = pfs.findByNom("ALAMI");
        for (Professeur p : profs) {
            System.out.println("\nProfesseurs trouvés avec le nom ALAMI : \n " + "- " + p.getNom() +  " " + p.getPrenom() +" (" + p.getSpecialite() + ")");
        }

        //Filtrer par spécialité:
        List<Professeur> informatiqueProfs = pfs.findBySpecialite("Informatique");
        for (Professeur p : profs) {
            System.out.println("\nProfesseurs trouvés avec la spécialité Informatique : \n " + "- " + p.getNom() +  " " + p.getPrenom());
        }
        
    }
}
