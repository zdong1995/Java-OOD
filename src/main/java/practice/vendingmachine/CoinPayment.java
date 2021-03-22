package practice.vendingmachine;

// On-call: Coin payment team
public class CoinPayment implements Payment{
    @Override
    public PaymentType getType() {
        return PaymentType.COIN;
    }

    @Override
    public boolean pay(Product product) {
        // implement here
        return true;
    }
}
