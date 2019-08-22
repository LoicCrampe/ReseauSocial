import java.io.*;

public class StreamFile {

    public static void write(String _file, Object _object) {
        try {
            FileOutputStream fichier = new FileOutputStream(_file);
            ObjectOutputStream oos = new ObjectOutputStream(fichier);
            oos.writeObject(_object);
            oos.flush();
            oos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static Object read(String _file) {
        try {
            FileInputStream fichier = new FileInputStream(_file);
            ObjectInputStream ois = new ObjectInputStream(fichier);
            return ois.readObject();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


}
