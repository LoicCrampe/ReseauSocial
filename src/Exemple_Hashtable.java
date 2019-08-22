import java.util.*;

public class Exemple_Hashtable
{
    private Hashtable <String,String> dictionnaire;

    public Exemple_Hashtable ()
    {
        dictionnaire = new Hashtable <String,String> ();
    }

    public void ajouterDefinition ( String _mot        ,
                                    String _definition )
    {
        dictionnaire.put ( _mot , _definition );
    }

    public void supprimerDefinition ( String _mot )
    {
        dictionnaire.remove ( _mot );
    }

    public String getDefinition ( String _mot )
    {
        String definition = dictionnaire.get ( _mot );

        if ( definition == null )
        {
            definition = "Mot inconnu";
        }

        return definition;
    }

    public void afficherDictionnaire ()
    {
        Set<String> mots = dictionnaire.keySet();

        for ( String mot : mots)
        {
            System.out.println ( "Mot : " + mot + " => Definition : " + getDefinition ( mot) );
        }
    }

    public static void main ( String args [] )
    {
        Exemple_Hashtable ex = new Exemple_Hashtable ();

        ex.ajouterDefinition ( "A" , "Premiere lettre de l'alphabet" );
        ex.ajouterDefinition ( "Entéléchie" , "Principe métaphysique qui détermine un être à une existence définie" );
        ex.ajouterDefinition ( "Biffer" , "Supprimer, rayer" );
        ex.ajouterDefinition ( "Aponie" , "Paix du corps" );
        ex.ajouterDefinition ( "Alchimistratif" , "Art de chercher des solutions poëtiques" );


        ex.afficherDictionnaire ();

        System.out.println ( "La definition d'Aponie est : "   + ex.getDefinition ("Aponie") );
        System.out.println ( "La definition d'Ataraxie est : " + ex.getDefinition ("ataraxie") );

        ex.supprimerDefinition ( "A" );


        ex.afficherDictionnaire ();
    }
}