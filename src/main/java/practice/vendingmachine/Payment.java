package practice.vendingmachine;

public interface Payment {
    abstract PaymentType getType();
    abstract boolean pay(Product product);
}
