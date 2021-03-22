package practice.vendingmachine;

import java.text.SimpleDateFormat;
import java.util.*;

public class VMController {
    private static Map<Integer, Product> products; // <key: productId, value: product>
    private static Map<PaymentType, Payment> paymentRegistry;
    private static VMController instance; // singleton

    private VMController() {
        products = new HashMap<>();
        paymentRegistry = new HashMap<>();
    }

    public static VMController getInstance() {
        if (instance == null) {
            synchronized (VMController.class) {
                if (instance == null) {
                    instance = new VMController();
                }
            }
        }
        return instance;
    }

    public static boolean addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product should be valid");
        }
        if (products.containsKey(product.getId())) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            System.out.println("Product " + product.getName() + " is being updated at " + formatter.format(date));
        }
        products.put(product.getId(), product);
        return true;
    }

    public static boolean registerPayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment should be valid");
        }
        if (paymentRegistry.containsKey(payment.getType())) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            System.out.println("Product " + payment.getType() + " is being updated at " + formatter.format(date));
        }
        paymentRegistry.put(payment.getType(), payment);
        return true;
    }

    public static Payment getPaymentByType(PaymentType paymentType) {
        return paymentRegistry.getOrDefault(paymentType, null);
    }

    public static Product getProductById(int productId) {
        return products.getOrDefault(productId, null);
    }
}
