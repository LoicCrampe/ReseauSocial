import java.util.*;

public class Sport implements java.io.Serializable
 {
  private String nom;
  private Hashtable<String, Personne> pratiquants;

  public Sport ()
   {
    nom         = "";
    pratiquants = new Hashtable<> ();
   }

  public Sport ( String _nom )
   {
    nom         = _nom;
    pratiquants = new Hashtable<> ();
   }

  public void afficher ()
   {
    System.out.print ( "Le sport " + nom );

    if ( pratiquants.size() == 0 )
          {
           System.out.println (" n'est pas pratique");
          }
     else {
           System.out.println (" est pratique par : ");

        for(Map.Entry<String, Personne> pratiquantsEntry : pratiquants.entrySet()){
            System.out.println (" - " + pratiquantsEntry.getValue().getNom());
        }
          }
   }

  public void addPratiquant ( Personne _pratiquant )
   {
    pratiquants.put (_pratiquant.getNom(), _pratiquant );
   }

  public String toString ()
   {
    return nom;
   }

  public String getNom ()
   {
    return nom;
   }

 }
