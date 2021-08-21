package WithSerializable;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CryptoMain {
    private static final String FILENAME;

    static {
        FILENAME = "D:\\JAVA PROJECTS\\files\\src\\main\\java\\WithSerializable\\crypto.xml";
    }

    public static void main(String[] args) throws IOException {
        Tokens.exchange = "Binance"; // static
        List<Tokens> tokens = new ArrayList<>();
        tokens.add(new Tokens("BTC", BigDecimal.valueOf(39000), BigDecimal.valueOf(39500)));
        tokens.add(new Tokens("ETH", BigDecimal.valueOf(3129), BigDecimal.valueOf(3250)));
        System.out.println(" * Before * ");
        System.out.println(tokens);

        /* Перевод RAM данных в постоянную последовательность байтов*/
        writeToXMLFile(tokens);

//        Tokens.exchange = "Gate.io"; // поменяется exchange
        System.out.println(" * After * ");
        List<Tokens> getTokens = readFromXMLFile();
        System.out.println(getTokens);
    }

    private static void writeToFile(List<Tokens> tokens) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))){
            oos.writeObject(tokens);
            oos.flush();
        }
    }

    private static void writeToXMLFile(List<Tokens> tokens) throws IOException {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILENAME))))
        {
            xmlEncoder.setPersistenceDelegate(BigDecimal.class, xmlEncoder.getPersistenceDelegate(Integer.class)); // без этого BigDecimal не записывал
            xmlEncoder.writeObject(tokens);
            xmlEncoder.flush();
        }
    }

    private static List<Tokens> readFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            return (List<Tokens>) ois.readObject();
        }
    }

    private static List<Tokens> readFromXMLFile() throws IOException {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(FILENAME)))) {
            return (List<Tokens>) xmlDecoder.readObject();
        }
    }
}