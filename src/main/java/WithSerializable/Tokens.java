package WithSerializable;

import java.beans.Transient;
import java.io.*;
import java.math.BigDecimal;

public class Tokens implements Serializable {
    protected static String exchange;
    private String name;
    private BigDecimal buy;
    private BigDecimal sell;
    private transient BigDecimal profit; // transient почему-то не работает

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

    @Transient
    public BigDecimal getProfit() {
        return profit;
    }

    @Transient
    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException{
        oos.defaultWriteObject();
        //customized serialization code
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        //customized deserialization code
    }

    @Override
    public String toString() {
        return  name + ": $" + buy + " | $" + sell + " | profit: " + profit + " | exchange: " + exchange;
    }
}