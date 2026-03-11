interface PaymentGatway {
    void pay(double amount,String orderId);
}

class PayPalPaymentGatway implements PaymentGatway {
    @Override
    public void pay(double amount, String orderId) {
        System.out.println("Processing payment of $" + amount + " for order " + orderId + " through PayPal.");
    }
}

class RazorPayGatway{
    public void makePayment(double amount, String orderId) {
        System.out.println("Processing payment of $" + amount + " for order " + orderId + " through RazorPay.");
    }
}

class RazorPayAdapter implements PaymentGatway {
    private RazorPayGatway razorPayGatway;

    public RazorPayAdapter(RazorPayGatway razorPayGatway) {
        this.razorPayGatway = razorPayGatway;
    }

    @Override
    public void pay(double amount, String orderId) {
        razorPayGatway.makePayment(amount, orderId);
    }
}

class PaymentService {
    private PaymentGatway paymentGatway;

    public PaymentService(PaymentGatway paymentGatway) {
        this.paymentGatway = paymentGatway;
    }

    public void processPayment(double amount, String orderId) {
        paymentGatway.pay(amount, orderId);
    }
}   

public class PaymentGatwayExample {
    public static void main(String[] args) {
        PaymentGatway paypalGateway = new PayPalPaymentGatway();
        PaymentService paymentService1 = new PaymentService(paypalGateway);
        paymentService1.processPayment(100.0, "ORDER123");

        RazorPayGatway razorPayGatway = new RazorPayGatway();
        PaymentGatway razorPayAdapter = new RazorPayAdapter(razorPayGatway);
        PaymentService paymentService2 = new PaymentService(razorPayAdapter);
        paymentService2.processPayment(200.0, "ORDER456");
    }
}