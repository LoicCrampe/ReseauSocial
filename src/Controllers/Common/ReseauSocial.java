package Controllers.Common;

import Controllers.InterfaceGraphique.InterfaceGraphique;
import Controllers.StreamFile;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ReseauSocial implements java.io.Serializable
{
    private Vector <Personne> membres;
    private Vector <Sport>    sports;
    private Vector <Club>     clubs;

    private int              id;

    public ReseauSocial ()
    {
        membres = new Vector<Personne> ();
        sports  = new Vector<Sport> ();
        clubs   = new Vector<Club> ();

        id = 1;

        initialiser ();
    }

    public void addMembre ( String _prenom ,
                            String _nom    ,
                            int    _age    )
    {
        membres.add ( new Personne ( id++ , _prenom , _nom , _age ) );
    }

    public void addSport ( String _nom )
    {
        sports.add ( new Sport( _nom ) );
    }

    public void addClub ( String _nom )
    {
        clubs.add ( new Club( id++ , _nom ) );
    }

    public void addLienMembreSport ( int _rangMembre , int _rangSport )
    {
        membres.elementAt (_rangMembre).addSport ( sports.elementAt(_rangSport) );
    }

    public void addLienMembreSport ( String _nomMembre , String _nomSport )
    {
        int     indexMembre = -1;
        int     indexSport  = -1;

        for ( int i=0 ; i<membres.size() && indexMembre == -1 ; i++)
        {
            if ( membres.get (i).getNom () == _nomMembre )
            {
                indexMembre = i;
            }
        }

        for ( int i=0 ; i<sports.size() && indexSport == -1 ; i++)
        {
            if ( sports.get (i).getNom () == _nomSport )
            {
                indexSport = i;
            }
        }

        membres.elementAt (indexMembre ).addSport ( sports.elementAt(indexSport) );
    }

    public void addLienMembreClub ( int _rangMembre , int _rangClub )
    {
        membres.elementAt (_rangMembre ).addClub ( clubs.elementAt(_rangClub ) );
    }

    public void addLienMembreClub ( String _nomMembre , String _nomClub )
    {
        int     indexMembre = -1;
        int     indexClub  = -1;

        for ( int i=0 ; i<membres.size() && indexMembre == -1 ; i++)
        {
            if ( membres.elementAt (i).getNom () == _nomMembre )
            {
                indexMembre = i;
            }
        }

        for ( int i=0 ; i<clubs.size() && indexClub == -1 ; i++)
        {
            if ( clubs.elementAt (i).getNom () == _nomClub )
            {
                indexClub = i;
            }
        }

        membres.elementAt (indexMembre).addClub ( clubs.elementAt(indexClub) );
    }

    public void afficherMembres ()
    {
        System.out.println ("Liste des membres :");
        System.out.println ("-------------------");
        System.out.println ();

        for ( int i= 0 ; i<membres.size() ; i++ )
        {
            membres.get (i).afficher ();
            System.out.println ();
        }
    }

    public void afficherSports ()
    {
        System.out.println ("Liste des sports :");
        System.out.println ("------------------");
        System.out.println ();

        for ( int i= 0 ; i<sports.size() ; i++ )
        {
            sports.get (i).afficher ();
            System.out.println ();
        }
    }

    public void afficherClubs ()
    {
        System.out.println ("Liste des clubs :");
        System.out.println ("-----------------");
        System.out.println ();

        for ( int i= 0 ; i<clubs.size() ; i++ )
        {
            clubs.get (i).afficher (true);
            System.out.println ();
            clubs.get (i).afficherSportsPratiques ();
            System.out.println ();
        }


    }

    public void afficher ()
    {
        afficherMembres ();
        System.out.println ();
        afficherSports ();
        System.out.println ();
        afficherClubs ();
    }

    public void initialiser ()
    {
        addMembre ( "Jean"  , "Valjean" , 40 );
        addMembre ( "Marie" , "Therese" , 30 );
        addMembre ( "Marie" , "Pierre"  , 20 );

        addSport  ( "Boxe Francaise" );
        addSport  ( "Kayak"          );
        addSport  ( "Velo"           );
        addSport  ( "Golf"           );

        addLienMembreSport ( 0 , 0 );
        addLienMembreSport ( 0 , 1 );
        addLienMembreSport ( 0 , 2 );

        addLienMembreSport ( 1 , 0 );

        addLienMembreSport ( "Pierre" , "Velo" );

        addClub  ( "Savate Croco" );
        addClub  ( "Karaté Chem" );
        addClub  ( "VCC" );

        addLienMembreClub ( 0 , 0 );
        addLienMembreClub ( 0 , 1 );
        addLienMembreClub ( 0 , 2 );

        addLienMembreClub ( "Therese" , "VCC" );

    }

    public static void main ( String args [] )
    {
        try
        {
            BDD baseDeDonnees = new BDD ();
        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }

        InterfaceGraphique fenetre = new InterfaceGraphique();
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        (new Controllers.Common.ReseauSocial ()).afficher ();
//
//        ReseauSocial reseauSocial = new ReseauSocial();
//        StreamFile.write("reseauSocial.ser", reseauSocial);
//        StreamFile.write("membres.ser", reseauSocial.membres);
//        StreamFile.write("sports.ser", reseauSocial.sports);
//        StreamFile.write("clubs.ser", reseauSocial.clubs);

//        ReseauSocial result = (ReseauSocial) StreamFile.read("reseauSocial.ser");
//        if (result != null) {
//            result.afficher();
//        }

    }

    private void writeObject (ObjectOutputStream out) throws IOException
    {
        out.writeObject(membres);
        out.writeObject(sports);
        out.writeObject(clubs);
    }

    private void readObject (ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        this.membres    = (Vector<Personne>) in.readObject();
        this.sports     = (Vector<Sport>) in.readObject();
        this.clubs      = (Vector<Club>) in.readObject();
    }

    public Vector<Personne> getMembres(){
        return membres;
    }
}












