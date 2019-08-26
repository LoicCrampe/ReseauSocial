package Controllers.Common;
import java.io.*;
import java.sql.*;
public class BDD
{
    private Connection connexion;
    private Statement expression;

    public BDD ()
    {
        super();
        System.out.println ("Connexion à la base de données");
        connecter ("mySQL", "socialsport");
    }
    private void connecter (String moteurSQL, String _baseDeDonnees)
    {
        try
        {
            if (moteurSQL.compareTo("idb") == 0)
            {
                Class.forName ("jdbc.idbDriver").newInstance();
                connexion = DriverManager.getConnection
                        ("jdbc:idb:./bdd/socialsport.db");
            }
            else {
                if (moteurSQL.compareTo("mySQL") == 0)
                {
                    Class.forName ("com.mysql.jdbc.Driver").newInstance();

                    connexion = DriverManager.getConnection

                            ("jdbc:mysql://localhost/socialsport?user=root&password=");
                }
                else { throw new Exception (); }
            }
            expression = connexion.createStatement ();
            System.out.println ("Connexion a la base de données");
        }
        catch (ClassNotFoundException e)
        { System.err.println (e.getMessage()); }
        catch (InstantiationException e)
        { System.err.println (e.getMessage()); }
        catch (java.sql.SQLException e)
        { System.err.println (e.getMessage()); }
        catch (Exception e)
        { System.err.println ("Driver inconnu. C'est idb ou mySQL"); }
    }
    private void deconnecter()
    {
        try
        {
            connexion.close();
            System.out.println ("Deconnexion de la base de donnees");
        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }
    }

    public void addUtilisateur (String _prenom, String _nom)
    {
        try
        {
            ResultSet resultat = expression.executeQuery ("SELECT membres.prenom, membres.nom, sports.nom, clubs.nom FROM membres" +
                                                                " INNER JOIN sports ON sports.id = membres.idSport" +
                                                                " INNER JOIN clubs ON clubs.id = membres.idClub" +
                                                                " WHERE membres.prenom = " + _prenom + " AND membres.nom = " + _nom );
            if (resultat.next())
            {
                System.out.println ("Echec de l'ajout de l'utilisateur");
            }
            else {
                expression.executeUpdate ("INSERT INTO membres ('prenom', 'nom') VALUES (" +
                        proteger(_prenom) + "," +
                        proteger(_nom) + ")" );

                System.out.println ("Ajout d'une entree dans la table utilisateurs");
                System.out.println (" * " + _prenom);
                System.out.println (" * " + _nom);
            }
        }
        catch (java.sql.SQLException e) { System.err.println (e.getMessage()); }
    }

    private String proteger (String _chaine)
    {
        String chaine = new String ("'");
        char c;
        for (int i=0; i<_chaine.length(); i++)
        {
            c = _chaine.charAt(i);
            if (c == 39) chaine += "\\'";
            else if (c == 92) chaine += "\\" + "\\";
            else chaine += c;
        }
        chaine += "'";
        return chaine;
    }
}