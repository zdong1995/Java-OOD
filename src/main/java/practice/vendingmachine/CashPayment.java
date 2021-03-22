package practice.vendingmachine;

// On-call: Cash payment team
public class CashPayment implements Payment {
    @Override
    public PaymentType getType() {
        return PaymentType.CASH;
    }

    @Override
    public boolean pay(Product product) {
        // implement here
        return true;
    }
}
