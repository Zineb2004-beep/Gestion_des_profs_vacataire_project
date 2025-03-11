/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


public class AffectationCours {

    private Professeur prof;
    private Cour cour;
    

    public AffectationCours(Cour cour, Professeur prof) {
        this.prof = prof;
        this.cour = cour; 
    }

        
    
    public Professeur getProf() {
        return prof;
    }

    public void setProf(Professeur prof) {
        this.prof = prof;
    }

    public Cour getCour() {
        return cour;
    }

    public void setCour(Cour cour) {
        this.cour = cour;
    }

   
}
