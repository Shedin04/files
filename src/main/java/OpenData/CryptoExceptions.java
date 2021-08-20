package OpenData;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CryptoExceptions extends Exception{
    private static final Logger logger;

    static {
        logger = Logger.getLogger("Teams");
        logger.setLevel(Level.SEVERE); // фильтр
        try {
            FileHandler fh = new FileHandler("Teams.log",true);
            fh.setFormatter(new SimpleFormatter()); //чтобы записывалось как на консоли
            logger.addHandler(fh);
        } catch (IOException e) {
            System.err.println("Can't create log file" + Arrays.toString(e.getStackTrace()));
        }
    }

    public CryptoExceptions(String message) {
        super(message);
    }
}
