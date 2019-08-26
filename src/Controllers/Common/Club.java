package Controllers.Common;

import Controllers.Common.Personne;
import Controllers.Common.Profil;
import Controllers.Common.Sport;

import java.io.*;
import java.util.*;

public class Club extends Profil implements java.io.Serializable
{
    private String nom;
    private Hashtable<String, Personne> adherants;

    public Club(int _id, String _nom) {
        super(_id);

        nom = _nom;
        adherants = new Hashtable<>();
    }

    public void afficher(boolean _resume) {
        super.afficher();
        System.out.print("Le club " + nom);

        if (adherants.size() == 0) {
            System.out.println(" n'a aucun adherant");
        } else {
            System.out.println(" a " + adherants.size() + " adherant" + (adherants.size() > 1 ? "s" : "") + " : ");

            for (Map.Entry<String, Personne> adherantsEntry : adherants.entrySet()) {
                System.out.println(" - " + adherants.get(adherantsEntry.getValue().getNom()));
            }
        }
    }

    public void addAdherant(Personne personne) {
        adherants.put(personne.getNom(), personne);
    }

    public String toString() {
        return nom;
    }

    public String getNom() {
        return nom;
    }

    public void afficherSportsPratiques() {
        Hashtable<String, Sport> sportPratiquesParLesAdherantsDuClub = new Hashtable<>();

        for (Map.Entry<String, Personne> adherantsEntry : adherants.entrySet()) {
            Hashtable<String, Sport> sportPratiquesParLAdherants = adherants.get(adherantsEntry.getValue().getNom()).getSports();
            for(Map.Entry<String, Sport> sportEntry : sportPratiquesParLAdherants.entrySet()){
                sportPratiquesParLesAdherantsDuClub.putIfAbsent(sportEntry.getValue().getNom(), sportEntry.getValue());
            }
        }

        System.out.println("Les sports pratiqués par les membres du club :");
        for (Map.Entry<String, Sport> entry : sportPratiquesParLesAdherantsDuClub.entrySet()) {
            System.out.println(" - " + sportPratiquesParLesAdherantsDuClub.get(entry.getValue().getNom()));
        }

    }

    private void writeObject (ObjectOutputStream out) throws IOException
    {
        out.writeUTF(nom);
        out.writeObject(adherants);
    }

    private void readObject (ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        this.nom = in.readUTF();
        this.adherants = (Hashtable<String, Personne>) in.readObject();
    }

}
