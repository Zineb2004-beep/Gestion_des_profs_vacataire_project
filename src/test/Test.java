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
        Professeur p2 = new Professeur("BENANI", "Bilal", "Mathématique");
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
        System.out.println("\n**La nouvelle valeur est :" + p1.getSpecialite());

        c1.setSalle("salle I3");
        cs.update(c1);
        System.out.println("\n**La nouvelle valeur est :" + c1.getSalle());

        List<Professeur> professeurs = pfs.findAll();
        List<Cours> coursList = cs.findAll();

        System.out.println("\n--------Affichage des données---------");

        System.out.println("\n**Professeurs :");
        for (Professeur p : professeurs) {
            System.out.println("- " + p.getNom() + " " + p.getPrenom() + " (" + p.getSpecialite() + ")");
        }

        System.out.println("\n**Cours :");
        for (Cours c : coursList) {
            System.out.println("- " + c.getIntitule() + " (" + c.getSalle() + ")");
        }

        System.out.println("\n**Affectations :");
        List<AffectationCours> affectations = afs.findAll();
        if (affectations.size() != 0) {
            for (AffectationCours a : affectations) {
                System.out.println("- " + a);
            }
        } else {
            System.out.println("N'existe aucune affectation !");
        }

        //Rechercher un professeur par ID:
        Professeur prof;
        prof = pfs.findById(41);
        if (prof != null) {
            System.out.println("\n**Ce proffesseur existe: " + prof.getNom() + prof.getPrenom() + "( " + prof.getSpecialite() + " )");
        } else {
            System.out.println("\nCe proffesseur n' existe pas!! ");
        }

        //Rechercher un professeur par nom:
        List<Professeur> profs = pfs.findByNom("ALAMI");
        for (Professeur p : profs) {
            if (p != null) {
                System.out.println("\nProfesseurs trouvés avec le nom ALAMI : \n " + "- " + p.getNom() + " " + p.getPrenom() + " (" + p.getSpecialite() + ")");
            } else {
                System.out.println("\nN'existe aucune professeur avec le nom ALAMI !!");
            }

            //Filtrer par spécialité:
            List<Professeur> mathProfs = pfs.findBySpecialite("Mathématique");
            for (Professeur pf : mathProfs) {
                if (pf != null) {
                    System.out.println("\nProfesseurs trouvés avec la spécialité mathématique : \n " + "- " + pf.getNom() + " " + pf.getPrenom());
                } else {
                    System.out.println("\nN'existe aucune professeur avec la spécialité mathématique !!");
                }
            }

        }
    }
}
