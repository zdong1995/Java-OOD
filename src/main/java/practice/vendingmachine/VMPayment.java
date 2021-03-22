package practice.vendingmachine;

public class VMPayment {
    private final Payment payment;

    public VMPayment(Payment payment) {
        this.payment = payment;
    }

    public boolean pay(int productId) {
        Product product = VMController.getProductById(productId);
        return payment.pay(product);
    }
}
