package WithExternalize;

import java.io.*;
import java.util.List;

public class FileUtil {
    public static void writeToFile(List<Tokens> tokens, String FILENAME) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))){
            oos.writeObject(tokens);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Tokens> readFromFile(String FILENAME) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            return (List<Tokens>) ois.readObject();
        }
    }
}
