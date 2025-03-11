/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

public class AffectationCours {

    private Professeur prof;
    private Cours cour;

    public AffectationCours(Cours cour, Professeur prof) {
        this.prof = prof;
        this.cour = cour;
    }

    public Professeur getProf() {
        return prof;
    }

    public void setProf(Professeur prof) {
        this.prof = prof;
    }

    public Cours getCour() {
        return cour;
    }

    public void setCour(Cours cour) {
        this.cour = cour;
    }

    @Override
    public String toString() {
        return "Le professeur " + prof.getNom() + " " + prof.getPrenom() + " a le cour " + cour.getIntitule() + " dans la salle " + cour.getSalle();
    }

}
