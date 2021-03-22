package practice.vendingmachine;

public class TestDriver {
    public static void main(String[] args) {
        // instantiate payment
        VMController.registerPayment(new CardPayment());
        VMController.registerPayment(new CoinPayment());
        VMController.registerPayment(new CashPayment());

    }
}
