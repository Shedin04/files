package WithExternalize;

import java.io.*;
import java.math.BigDecimal;

public class Tokens implements Externalizable {
    private String name;
    private BigDecimal buy;
    private BigDecimal sell;
    private BigDecimal profit;
    private Exchanges exchange;

    public Tokens(){
        /*чтобы не было проблем с десереализацией*/
    }

    public Tokens(String name, BigDecimal buy, BigDecimal sell, Exchanges exchange) {
        this.name = name;
        this.buy = buy;
        this.sell = sell;
        this.profit = sell.subtract(buy);
        this.exchange = exchange;
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

    public Exchanges getExchange() {
        return exchange;
    }

    public void setExchange(Exchanges exchange) {
        this.exchange = exchange;
    }

    @Override
    public String toString() {
        return "{" + name + ": $" + buy + " | $" + sell + " | profit: " + profit + " | exchange: " + exchange + "}";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException { //выбираем, что записать
        out.writeObject(name);
        out.writeObject(buy);
        out.writeObject(sell);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        buy = (BigDecimal) in.readObject();
        sell = (BigDecimal) in.readObject();
    }
}