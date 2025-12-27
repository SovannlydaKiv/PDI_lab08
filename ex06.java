public class ex06 {
    public static void main(String[] args) {
        System.out.println(" Order Service: \n");
        OrderProcessor oP = new OrderProcessor();
        BillingService bill = new BillingService();
        OrderRepository orderRepo = new OrderRepository();
        InvoiceEmailService invoiceEmail = new InvoiceEmailService();
        
        oP.takeOrder();
        bill.calculateBill();
        orderRepo.saveOrder();
        invoiceEmail.sendInvoiceEmail();
        System.out.println();
    }
}

class OrderProcessor {
    String orderId;
    String orderDate;
    String customerName;
    
    void takeOrder() {
        System.out.println("Order taken");
    }
    
    void validateOrder() {
        System.out.println("Order validated");
    }
    
    void confirmOrder() {
        System.out.println("Order confirmed");
    }
}

class BillingService {
    double totalAmount;
    double taxRate;
    String invoiceNumber;
    
    void calculateBill() {
        System.out.println("Bill calculated");
    }
    
    void applyTax() {
        System.out.println("Tax applied");
    }
    
    double getFinalAmount() {
        return totalAmount;
    }
}

class OrderRepository {
    String databaseConnection;
    int orderCount;
    String tableName;
    
    void saveOrder() {
        System.out.println("Order saved");
    }
    
    void updateOrder() {
        System.out.println("Order updated");
    }
    
    void deleteOrder() {
        System.out.println("Order deleted");
    }
}

class InvoiceEmailService {
    String emailTemplate;
    String senderAddress;
    int emailsSent;
    
    void sendInvoiceEmail() {
        System.out.println("Invoice email sent");
    }
    
    void generateInvoice() {
        System.out.println("Invoice generated");
    }
    
    void attachInvoice() {
        System.out.println("Invoice attached");
    }
}