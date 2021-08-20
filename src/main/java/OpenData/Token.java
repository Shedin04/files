package OpenData;

import java.math.BigDecimal;

public class Token {
    private String name;
    private BigDecimal buy;
    private BigDecimal sell;

    public Token(String name, BigDecimal buy, BigDecimal sell) {
        this.name = name;
        this.buy = buy;
        this.sell = sell;
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
        return  name + ": $" + buy + " | $" + sell;
    }
}
