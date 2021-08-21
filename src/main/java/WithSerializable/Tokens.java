package WithSerializable;

import java.io.Serializable;
import java.math.BigDecimal;

public class Tokens implements Serializable {
    protected static String exchange;
    private String name;
    private BigDecimal buy;
    private  BigDecimal sell;
    private transient BigDecimal profit;

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

    @Override
    public String toString() {
        return  name + ": $" + buy + " | $" + sell + " | profit: " + profit + " | exchange: " + exchange;
    }
}