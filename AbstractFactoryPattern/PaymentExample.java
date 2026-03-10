interface paymentGateway {
    void processPayment(double amount);
}

interface invoice{
    void generateInvoice(double amount);
}


// ----------------------------------------////  
class PayPalPaymentGateway implements paymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

class StripePaymentGateway implements paymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

class USAInvoice implements invoice {
    @Override
    public void generateInvoice(double amount) {
        System.out.println("Generating invoice for $" + amount + " in USA format.");
    }
}

interface regionFactory {
    paymentGateway createPaymentGateway(String gatewayType);
    invoice createInvoice();
}

class USARegionFactory implements regionFactory {
    @Override
    public paymentGateway createPaymentGateway(String gatewayType) {
        switch (gatewayType) {
            case "PayPal":
                return new PayPalPaymentGateway();
            case "Stripe":
                return new StripePaymentGateway();
            default:
                throw new IllegalArgumentException("Unsupported payment gateway");
        }
    }

    @Override
    public invoice createInvoice() {
        return new USAInvoice();
    }
}

class checkoutService {
    private regionFactory factory;
    private paymentGateway gateway;
    private invoice invoice;

    public checkoutService(regionFactory factory, String gatewayType) {
        this.factory = factory;
        this.gateway = factory.createPaymentGateway(gatewayType);
        this.invoice = factory.createInvoice();
    }

    public void checkout(double amount) {
        gateway.processPayment(amount);
        invoice.generateInvoice(amount);
    }   
}

public class PaymentExample {
    public static void main(String[] args) {
        regionFactory usaFactory = new USARegionFactory();
        checkoutService checkout = new checkoutService(usaFactory, "PayPal");
        checkout.checkout(100.0);
    }
}


//create documentation for the above code
/**
 * This code demonstrates the Abstract Factory design pattern in the context of a payment processing system.
 * It defines interfaces for payment gateways and invoice generation, and then implements these interfaces
 * for specific regions (in this case, the USA). The checkout service uses the factory to create the appropriate
 * payment gateway and invoice generator based on the region and gateway type specified.
 *
 * Key components:
 * - paymentGateway: An interface for processing payments.
 * - invoice: An interface for generating invoices.
 * - PayPalPaymentGateway and StripePaymentGateway: Concrete implementations of the paymentGateway interface.
 * - USAInvoice: A concrete implementation of the invoice interface for the USA region.
 * - regionFactory: An interface for creating families of related objects (payment gateways and invoices).
 * - USARegionFactory: A concrete implementation of the regionFactory that creates USA-specific payment gateways and invoices.
 * - checkoutService: A service that uses the regionFactory to process payments and generate invoices based on the specified region and gateway type.
 *
 * The main method demonstrates how to use the checkoutService with a USARegionFactory to process a payment through PayPal and generate an invoice.
 */