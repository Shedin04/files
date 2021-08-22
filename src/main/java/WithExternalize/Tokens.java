package WithExternalize;

import java.beans.Transient;
import java.io.*;
import java.math.BigDecimal;

public class Tokens implements Externalizable {
    protected static String exchange;
    private String name;
    private BigDecimal buy;
    private BigDecimal sell;
    private BigDecimal profit;

    public Tokens(){
        /*чтобы не было проблем с десереализацией*/
        this("TOKEN",BigDecimal.ZERO,BigDecimal.ZERO); //по-ум.
    }


    public Tokens(String name, BigDecimal buy, BigDecimal sell) {
        this.name = name;
        this.buy = buy;
        this.sell = sell;
        this.profit = sell.subtract(buy);
    }

    public static String getExchange() {
        return exchange;
    }

    public static void setExchange(String exchange) {
        Tokens.exchange = exchange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return  name + ": $" + buy + " | $" + sell + " | profit: " + profit + " | exchange: " + exchange;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException { //выбираем, что записать
        out.writeObject(name);
        out.writeObject(buy);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        buy = (BigDecimal) in.readObject();
    }
}