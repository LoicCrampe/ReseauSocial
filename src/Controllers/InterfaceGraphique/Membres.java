package Controllers.InterfaceGraphique;

import Controllers.Common.Club;
import Controllers.Common.Sport;

import java.util.Hashtable;
import java.util.Vector;

public class Membres {
    private String          nom;
    private String          prenom;
    private int             age;
    private Hashtable<String, Sport> sports;
    private Hashtable<String, Club> clubs;

    public Membres(String prenom, String nom, int age) {
        super();

        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAge() {
        return age + "";
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Hashtable<String, Sport> getSports() {
        return sports;
    }

    public void setSport(Hashtable<String, Sport> sports) {
        this.sports = sports;
    }

    public Hashtable<String, Club> getClubs() {
        return clubs;
    }

    public void setClubs(Hashtable<String, Club> clubs) {
        this.clubs = clubs;
    }
}
