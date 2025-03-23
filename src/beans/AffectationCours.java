/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

public class AffectationCours {

    private Professeur professeur;
    private Cours cours;

    public AffectationCours(Professeur professeur , Cours cours) {
        this.professeur = professeur;
        this.cours = cours;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    @Override
    public String toString() {
        return professeur.getNom() + " " + professeur.getPrenom() + cours.getIntitule() + " " + cours.getSalle();
    }

}
