abstract class Notification{
    public final void send(String to,String rawMessage){

      rateLimitCheck(to);
      validateRecipient(to);
      String message = formatMessage(rawMessage);
      preSendAuditLog(to,message);

      String composedMessage = composeMessage(message);
      sendMessage(to,composedMessage);

      //optional
      postSendAnalytics(to);
    }


    protected void rateLimitCheck(String to){
        System.out.println("Checking rate limits for: " + to);
        //default implementation
    }

    protected void validateRecipient(String to){
        System.out.println("Validating recipient: " + to);
        //default implementation
    }

    private String formatMessage(String message) {
        return message.trim(); // could include HTML escaping, emoji processing, etc.
    }

    // Common step 4: Pre-send audit log
    private void preSendAuditLog(String to, String formatted) {
        System.out.println("Logging before send: " + formatted + " to " + to);
    }

    // Hook for subclasses to implement custom message composition
    protected abstract String composeMessage(String formattedMessage);

    // Hook for subclasses to implement custom message sending
    protected abstract void sendMessage(String to, String message);

    // Optional hook for analytics (can be overridden)
    protected void postSendAnalytics(String to) {
        System.out.println("Analytics updated for: " + to);
    }
}

class EmailNotification extends Notification{

    @Override
    protected String composeMessage(String formattedMessage) {
        return "Email: " + formattedMessage;
    }

    @Override
    protected void sendMessage(String to, String message) {
        System.out.println("Sending email to " + to + ": " + message);
    }
}

class SMSNotification extends Notification{

    @Override
    protected String composeMessage(String formattedMessage) {
        return "SMS: " + formattedMessage;
    }

    @Override
    protected void sendMessage(String to, String message) {
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}

public class NotificationExample {

    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification();
        emailNotification.send("user@example.com", "Hello, this is an email notification!");

        Notification smsNotification = new SMSNotification();
        smsNotification.send("1234567890", "Hello, this is an SMS notification!");
    }
}   


// create documentation for the above code and UML class diagram
/**
 * This code demonstrates the Template Design Pattern using a notification example.
 * The abstract class `Notification` defines a template method `send()` that outlines
 * the steps for sending a notification. Subclasses like `EmailNotification` and
 * `SMSNotification` provide specific implementations for composing and sending messages.
 *
 * The template method ensures that the overall process of sending a notification is
 * consistent, while allowing subclasses to customize certain steps as needed.
 *
 * UML Class Diagram:
 *
 * +------------------+          +-----------------------+
 * |   Notification   |          |  EmailNotification    |
 * +------------------+          +-----------------------+
 * | - send()         |<>--------| - composeMessage()    |
 * | - rateLimitCheck()|          | - sendMessage()      |
 * | - validateRecipient()|       +-----------------------+
 * | - formatMessage()  |
 * | - preSendAuditLog()|
 * | - postSendAnalytics()|
 * +------------------+
 *
 * +------------------+          +-----------------------+
 * |   Notification   |          |  SMSNotification      |
 * +------------------+          +-----------------------+
 * | - send()         |<>--------| - composeMessage()    |
 * | - rateLimitCheck()|          | - sendMessage()      |
 * | - validateRecipient()|       +-----------------------+
 * | - formatMessage()  |
 * | - preSendAuditLog()|
 * | - postSendAnalytics()|
 * +------------------+
 */         
