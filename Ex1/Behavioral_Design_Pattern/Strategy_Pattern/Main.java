import java.util.Scanner;

// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy 1
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

// Concrete Strategy 2
class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Context Class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment method not set");
        }
        paymentStrategy.pay(amount);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        System.out.println("Choose payment method: 1.Credit Card 2.PayPal");
        int choice = scanner.nextInt();
        System.out.print("Enter amount: ");
        int amount = scanner.nextInt();

        switch (choice) {
            case 1:
                cart.setPaymentStrategy(new CreditCardPayment());
                break;
            case 2:
                cart.setPaymentStrategy(new PayPalPayment());
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        cart.checkout(amount);
        scanner.close();
    }
}
