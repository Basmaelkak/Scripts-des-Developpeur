/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

/**
 *
 * @author pc
 */
public class DevData {
     String developpeur;
    String jour;
    int nbrscripts;
    

    public DevData(String nom) {
        this.developpeur = developpeur;
    }

    public DevData(String nom, String jour, int nbrscripts) {
        this.developpeur = developpeur;
        this.jour = jour;
        this.nbrscripts = nbrscripts;
    }

    public DevData(String developpeur, String jour) {
        this.developpeur = developpeur;
        this.jour = jour;
    }
    
    

    public String getDeveloppeur() {
        return developpeur;
    }

    public String getJour() {
        return jour;
    }

    public int getNbrscripts() {
        return nbrscripts;
    }

    public void setDeveloppeur(String developpeur) {
        this.developpeur = developpeur;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public void setNbrscripts(int nbrscripts) {
        this.nbrscripts = nbrscripts;
    }

   
   
    
    
}
