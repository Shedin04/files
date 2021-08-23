package WithExternalize;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainExternalize {
    private static final String FILENAME;

    static {
        FILENAME = "D:\\JAVA PROJECTS\\files\\src\\main\\java\\WithExternalize\\crypto.dat";
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Tokens> tokens = new ArrayList<>();
        tokens.add(new Tokens("BTC", BigDecimal.valueOf(39000), BigDecimal.valueOf(39500), Exchanges.COINBASE));
        tokens.add(new Tokens("ETH", BigDecimal.valueOf(3129), BigDecimal.valueOf(3250), Exchanges.BINANCE));
        System.out.println(" * Before * ");
        System.out.println(tokens);

        System.out.println("\n * Search tokens by exchange *");
        TokensUtil.getExchangeToken(tokens, Exchanges.BINANCE);

        System.out.println("\n * Total profit *");
        BigDecimal profit = TokensUtil.getTotalProfit(tokens);

        FileUtil.writeToFile(tokens, FILENAME); /* Перевод RAM данных в постоянную последовательность байтов*/

        System.out.println("\n * After * ");
        tokens.clear();
        tokens = FileUtil.readFromFile(FILENAME);
        System.out.println(tokens);
    }
}