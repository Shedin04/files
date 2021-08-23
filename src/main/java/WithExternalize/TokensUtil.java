package WithExternalize;

import java.math.BigDecimal;
import java.util.List;

public class TokensUtil {
    private static int error;

    protected static void getExchangeToken(List<Tokens> list, Exchanges exchange){
        System.out.print(exchange.fullname + " tokens: ");
        try {
            for (var token:
                    list) {
                if (exchange.equals(token.getExchange()))
                    System.out.println(token);
                else error++;
            }
            if (error == list.size()) throw new IllegalStateException("[tokens not found]");
        } catch (IllegalStateException e){
            System.err.println("[ERROR] - Tokens not found");
        }
    }

    protected static BigDecimal getTotalProfit(List<Tokens> list){
        BigDecimal total = BigDecimal.ZERO;
        for (var token:list) {
            total = total.add(token.getProfit());
        }
        System.out.println("Total profit: " + total);
        return total;
    }
}
