package practice.vendingmachine;

// On-call: Credit card payment team
public class CardPayment implements Payment {
    @Override
    public PaymentType getType() {
        return PaymentType.CARD;
    }

    @Override
    public boolean pay(Product product) {
        // implement here
        return true;
    }
}
