public class ex04 {
    public static void main(String[] args) {
        System.out.println("Basic phone functions: ");
        BasicPhone basicPhone = new BasicPhone("123-456-789");
        basicPhone.call();
        basicPhone.sendSMS();

        System.out.println("\nSmartphone functions: ");
        SmartPhone smartPhone = new SmartPhone("567-123-890");
        smartPhone.browseInternet();
        smartPhone.takePhoto();
    }
}
interface Callable {
    void call();
    void endCall();
    void muteCall();
}

interface Messaging {
    void sendSMS();
    void receiveSMS();
    void deleteSMS();
}

interface WebCapable {
    void browseInternet();
    void openBrowser();
    void clearCache();
}

interface Camera {
    void takePhoto();
    void recordVideo();
    void switchCamera();
}

class BasicPhone implements Callable, Messaging {
    String phoneNumber;
    String manufacturer;
    int batteryLevel;
    
    public BasicPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.batteryLevel = 100;
    }
    
    public void call() {
        System.out.println("Making call...");
    }
    
    public void endCall() {
        System.out.println("Call ended");
    }
    
    public void muteCall() {
        System.out.println("Call muted");
    }
    
    public void sendSMS() {
        System.out.println("Sending SMS...");
    }
    
    public void receiveSMS() {
        System.out.println("SMS received");
    }
    
    public void deleteSMS() {
        System.out.println("SMS deleted");
    }
}

class SmartPhone implements Callable, Messaging, WebCapable, Camera {
    String phoneNumber;
    String model;
    int storageGB;
    
    public SmartPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.model = "SmartPhone X";
        this.storageGB = 128;
    }
    
    public void call() {
        System.out.println("Video call ready");
    }
    
    public void endCall() {
        System.out.println("Call ended");
    }
    
    public void muteCall() {
        System.out.println("Call muted");
    }
    
    public void sendSMS() {
        System.out.println("Sending SMS with emoji");
    }
    
    public void receiveSMS() {
        System.out.println("SMS received");
    }
    
    public void deleteSMS() {
        System.out.println("SMS deleted");
    }
    
    public void browseInternet() {
        System.out.println("Browsing web...");
    }
    
    public void openBrowser() {
        System.out.println("Browser opened");
    }
    
    public void clearCache() {
        System.out.println("Cache cleared");
    }
    
    public void takePhoto() {
        System.out.println("Photo taken");
    }
    
    public void recordVideo() {
        System.out.println("Recording video");
    }
    
    public void switchCamera() {
        System.out.println("Camera switched");
    }
}