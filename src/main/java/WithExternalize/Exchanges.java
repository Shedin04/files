package WithExternalize;

public enum Exchanges {
    BINANCE("Binance"),
    GATE("Gate.io"),
    CRYPTO("Crypto.com"),
    COINBASE("Coinbase Exchange"),
    HUOBI("Huobi Global");

    String fullname;

    Exchanges(String fullname) {
        this.fullname = fullname;
    }
}
