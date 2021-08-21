package WithSerializable;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String FILENAME;
    private static List<Tokens> tokens;
    private static List<Tokens> getTokens;

    static {
        FILENAME = "D:\\JAVA PROJECTS\\files\\src\\main\\java\\WithSerializable\\crypto.dat";
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Tokens.exchange = "Binance"; // static
        tokens = new ArrayList<Tokens>();
        tokens.add(new Tokens("BTC", BigDecimal.valueOf(39000), BigDecimal.valueOf(39500)));
        tokens.add(new Tokens("ETH", BigDecimal.valueOf(3129), BigDecimal.valueOf(3250)));
        System.out.println(" * Before * ");
        System.out.println(tokens);

        /* Перевод RAM данных в постоянную последовательность байтов*/
        writeToFile(tokens);

//        Tokens.exchange = "Gate.io"; //
        System.out.println(" * After * ");
        getTokens = readFromFile();
        System.out.println(getTokens);
    }

    private static void writeToFile(List<Tokens> tokens) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))){
            oos.writeObject(tokens);
            oos.flush();
        }
    }

    private static List<Tokens> readFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            return (List<Tokens>) ois.readObject();
        }
    }
}