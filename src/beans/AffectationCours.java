/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

public class AffectationCours {

    private Professeur professeur_id;
    private Cours cours_id;

    public AffectationCours(Professeur prof , Cours cour) {
        this.professeur_id = prof;
        this.cours_id = cour;
    }

    public Professeur getProf() {
        return professeur_id;
    }

    public void setProf(Professeur prof) {
        this.professeur_id = prof;
    }

    public Cours getCour() {
        return cours_id;
    }

    public void setCour(Cours cour) {
        this.cours_id = cour;
    }

    @Override
    public String toString() {
        return "Le professeur " + professeur_id.getNom() + " " + professeur_id.getPrenom() + " a le cour " + cours_id.getIntitule() + " dans la salle " + cours_id.getSalle();
    }

}
