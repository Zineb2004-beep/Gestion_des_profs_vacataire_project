/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


public class Cour {
    private int id;
    private String intitule;
    private String salle;
    
    public Cour(int id, String intitule, String salle) {
        this.id = id;
        this.intitule = intitule;
        this.salle = salle;
    }
    public Cour(String intitule, String salle) {
        this.intitule = intitule;
        this.salle = salle;
    }
      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }
    
    @Override
    public String toString() {
    return 
           "Intitule :" + intitule + "\n" +
           "Salle :" + salle + "\n" ;
}


}
