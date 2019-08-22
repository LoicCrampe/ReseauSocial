import java.io.*;

public class Serialisable implements java.io.Serializable
{

    public static void main(final String argv[]) {
        final Personne personne = new Personne(14, "Jean", "Dupond",75);
        ObjectOutputStream oos = null;

        try {
            final FileOutputStream fichier = new FileOutputStream("personne.ser");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(personne);
            oos.flush();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}