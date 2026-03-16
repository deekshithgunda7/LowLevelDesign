import java.util.*;

interface subscriber {
    void update(String videoTitle);
}

class EmailSubscriber implements subscriber {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("Email sent to " + email + ": New video uploaded - " + videoTitle);
    }
}


class MobileSubscriber implements subscriber {
    private String phoneNumber;

    public MobileSubscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("SMS sent to " + phoneNumber + ": New video uploaded - " + videoTitle);
    }
}

interface channel {
    void subscribe(subscriber sub);
    void unsubscribe(subscriber sub);
    void notifySubscribers(String videoTitle);
}

class YoutubeChannel implements channel {
    private List<subscriber> subscribers;

    public YoutubeChannel() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(subscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void unsubscribe(subscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(String videoTitle) {
        for (subscriber sub : subscribers) {
            sub.update(videoTitle);
        }
    }
}



class YoutubeChannelExample {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel();

        subscriber emailSub1 = new EmailSubscriber("alice@example.com");
        subscriber emailSub2 = new EmailSubscriber("bob@example.com");
        subscriber mobileSub1 = new MobileSubscriber("123-456-7890");
        subscriber mobileSub2 = new MobileSubscriber("098-765-4321");

        channel.subscribe(emailSub1);
        channel.subscribe(emailSub2);
        channel.subscribe(mobileSub1);
        channel.subscribe(mobileSub2);

        channel.notifySubscribers("Java Programming Tutorial");
    }
}

