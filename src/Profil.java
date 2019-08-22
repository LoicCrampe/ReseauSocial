public class Profil implements java.io.Serializable
 {
  protected int id;

  public Profil ( int _id )
   {
    id = _id;
   }

  public void afficher ()
   {
    System.out.println ("Profil numero " + id);
   }
 }
