package Controllers.Common;

public class Profil implements java.io.Serializable
 {
  protected int id;

  public Profil ( int _id )
   {
    id = _id;
   }

  public void afficher ()
   {
    System.out.println ("Controllers.Common.Profil numero " + id);
   }
 }
