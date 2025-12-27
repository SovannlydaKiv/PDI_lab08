public class ex07 {
    public static void main(String[] args) {
        System.out.println("Your notification service: \n");
        NotificationService notifService = new NotificationService();
        
        Notification email = new EmailNotification("user@example.com", "helllooo!");
        Notification sms = new SMSNotification("1234567890", "Your OTP is 1234");
        Notification push = new PushNotification("lyda's device", "You have a new message!");
        
        notifService.sendNotification(email);
        notifService.sendNotification(sms);
        notifService.sendNotification(push);
        System.out.println("Total notifications sent: " + notifService.getSentCount());
        System.out.println();
    }
}

interface Notification {
    void send();
    boolean validate();
    void logNotification();
}

class EmailNotification implements Notification {
    String recipient;
    String message;
    String timestamp;
    
    public EmailNotification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }
    
    public void send() {
        System.out.println("Sending email to: " + recipient);
    }
    
    public boolean validate() {
        return recipient.contains("@");
    }
    
    public void logNotification() {
        System.out.println("Email logged at: " + timestamp);
    }
}

class SMSNotification implements Notification {
    String recipient;
    String message;
    String timestamp;
    
    public SMSNotification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }
    
    public void send() {
        System.out.println("Sending SMS to: " + recipient);
    }
    
    public boolean validate() {
        return recipient.length() >= 10;
    }
    
    public void logNotification() {
        System.out.println("SMS logged at: " + timestamp);
    }
}

class PushNotification implements Notification {
    String recipient;
    String message;
    String timestamp;
    
    public PushNotification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }
    
    public void send() {
        System.out.println("Sending push notification to: " + recipient);
    }
    
    public boolean validate() {
        return recipient != null && !recipient.isEmpty();
    }
    
    public void logNotification() {
        System.out.println("Push notification logged at: " + timestamp);
    }
}

class NotificationService {
    String serviceName;
    int notificationsSent;
    boolean isActive;
    
    void sendNotification(Notification notification) {
        if (notification.validate()) {
            notification.send();
            notification.logNotification();
            notificationsSent++;
        }
    }
    
    void sendBulkNotifications(Notification[] notifications) {
        for (Notification n : notifications) {
            sendNotification(n);
        }
    }
    
    int getSentCount() {
        return notificationsSent;
    }
}
