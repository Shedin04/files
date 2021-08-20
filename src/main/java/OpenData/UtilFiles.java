package OpenData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class UtilFiles {
    private static ArrayList<Token> tokens;

    protected static ArrayList readFile(String name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(name, Charset.forName("WINDOWS-1251")));
        tokens = getTokens(br);
        return tokens;
    }


    protected static ArrayList readURLFile(String site) throws IOException {
        URL datasheet = new URL(site);
        URLConnection connection = datasheet.openConnection();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        tokens = getTokens(br);
        return tokens;
    }

    private static ArrayList<Token> getTokens(BufferedReader br) throws IOException {
        tokens = new ArrayList<>();
        String [] title = br.readLine().split(";");
        while (br.ready()) { // пока что-то есть
            String[] str = br.readLine()
                    .replaceAll(",", ".") // заменяем запятые на точки
                    .split(";"); // разделяем элементы
            tokens.add(new Token(
                    str[0],
                    BigDecimal.valueOf(Double.parseDouble(str[1])),
                    BigDecimal.valueOf(Double.parseDouble(str[2]))));
        }
        return tokens;
    }
}
