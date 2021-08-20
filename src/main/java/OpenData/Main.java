package OpenData;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;

public class Main {
    private static String FILENAME;
    private static String FILEURL;
    static {
        FILENAME = "D:\\JAVA PROJECTS\\files\\src\\main\\java\\OpenData\\crypto.csv";
        FILEURL = "https://docs.google.com/uc?id=1rjQ2s5QUyXZBiPRWSuL7QjWxgoQarqwM";
    }
    public static void main(String[] args) throws IOException {
        List<Token> getTokens = UtilFiles.readFile(FILENAME);
        TokenUtil.allInfo(getTokens);

        /*List<Token> getURLTokens = UtilFiles.readURLFile(FILEURL);
        TokenUtil.allInfo(getURLTokens);*/

        TokenUtil.maxBuy(getTokens);
        TokenUtil.maxSell(getTokens);
        TokenUtil.maxProfit(getTokens);

        getTokens.add(new Token("Gsg", BigDecimal.valueOf(48000), BigDecimal.valueOf(40000)));

        UtilFiles.writeFile(getTokens, FILENAME);
    }
}
