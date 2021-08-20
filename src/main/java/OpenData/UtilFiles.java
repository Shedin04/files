package OpenData;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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

    protected static void writeFile(List<Token> tokens, String name) throws IOException {
        int i = 0;
        StringBuilder title = new StringBuilder();
        title.append("Token;Buy;Sell\n"); // Для строк лучше юзать стрингбилдер
        FileWriter fwr = new FileWriter(name);
        fwr.write(String.valueOf(title)); // Записываем стрингбилдер
        for (var token : tokens) {
            fwr.write(token.getName() + ";" + token.getBuy() + ";" + token.getSell());
            i++;
            if (i < tokens.size()) fwr.write("\n");
        }
        fwr.close();
    }

    protected static void writeToBinaryFile(List<Token> tokens, String name) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(name));
        for (var token: tokens) {
            dos.writeUTF(token.getName());
            dos.writeFloat(Float.valueOf(String.valueOf(token.getSell())));
            dos.writeFloat(Float.valueOf(String.valueOf(token.getBuy())));
        }
        dos.close();
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
