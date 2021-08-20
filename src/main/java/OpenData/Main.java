package OpenData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
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
    }
}
