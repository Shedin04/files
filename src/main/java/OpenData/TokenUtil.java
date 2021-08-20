package OpenData;

import java.util.List;

public class TokenUtil {
private static String STARS;
static {
    STARS="*  *  *  *  *  *  *\n";
}

    static Token maxBuy(List<Token> getTokens){
        System.out.println("* * * Max Buy * * *");
        Token max = getTokens.get(0);
        for (var token: getTokens) {
            if (token.getBuy().compareTo(max.getBuy()) > 0)
                max = token;
        }
        System.out.println(max + "\n" + STARS);
        return max;
    }

    static Token maxSell(List<Token> getTokens){
        System.out.println("* * * Max Sell * * *");
        Token max = getTokens.get(0);
        for (var token: getTokens) {
            if (token.getSell().compareTo(max.getSell()) > 0)
                max = token;
        }
        System.out.println(max + "\n" + STARS);
        return max;
    }

    static void allInfo(List<Token> getTokens) {
        System.out.println("* * * Your tokens * * *");
        System.out.println("NAME    BUY    SELL");
        for (var str:
             getTokens) {
            System.out.println(str.toString());
        }
        System.out.println(STARS);
    }
}
