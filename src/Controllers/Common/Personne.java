package Controllers.Common;

import java.io.*;
import java.util.*;

public class Personne extends Profil implements java.io.Serializable
{
    private String prenom;
    private String nom;
    private int age;
    private Hashtable<String, Sport> sports;
    private Hashtable<String, Club> clubs;

    public Personne(int _id,
                    String _prenom,
                    String _nom,
                    int _age) {
        super(_id);

        prenom = _prenom;
        nom = _nom;
        age = _age;

        sports = new Hashtable<>();
        clubs = new Hashtable<>();
    }

    public void afficher() {
        super.afficher();

        System.out.print(prenom + " " + nom + " a " + age + " an" + (age > 1 ? "s" : ""));

        if (sports.size() == 0) {
            System.out.println(", ne pratique aucun sport");
        } else {
            System.out.println(", pratique " + sports.size() + " sport" + (sports.size() > 1 ? "s" : "") + " : ");

            for (Map.Entry<String, Sport> sportsEntry : sports.entrySet()) {
                System.out.println(" - " + sportsEntry.getValue().getNom());
            }
        }

        if (clubs.size() == 0) {
            System.out.println(" et n'est inscrit dans aucun club");
        } else {
            System.out.println(" et est inscrit dans " + clubs.size() + " club" + (clubs.size() > 1 ? "s" : "") + " : ");

            for (Map.Entry<String, Club> clubsEntry : clubs.entrySet()) {
                System.out.println(" - " + clubsEntry.getValue().getNom());
            }
        }

    }

    public void addSport(Sport _sport) {
        sports.put(_sport.getNom(), _sport);
        _sport.addPratiquant(this);
    }

    public void addClub(Club _club) {
        clubs.put(_club.getNom(), _club);
        _club.addAdherant(this);
    }

    public String toString() {
        return prenom + " " + nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String _nom){
        this.nom = _nom;
    }

    public String getPrenom() {
    return prenom;
}

    public void setPrenom(String _prenom){
        this.prenom = _prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int _age){
        this.age = _age;
    }

    public Hashtable<String, Sport> getSports() {
        return sports;
    }

    public Hashtable<String, Club> getClubs() {
        return clubs;
    }

    private void writeObject (ObjectOutputStream out) throws IOException
    {
        out.writeUTF(nom);
        out.writeUTF(prenom);
        out.writeInt(age);
        out.writeObject(sports);
        out.writeObject(clubs);
    }

    private void readObject (ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        this.nom = in.readUTF();
        this.prenom = in.readUTF();
        this.age = in.readInt();
        this.sports = (Hashtable<String, Sport>) in.readObject();
        this.clubs = (Hashtable<String, Club>) in.readObject();
    }
}
