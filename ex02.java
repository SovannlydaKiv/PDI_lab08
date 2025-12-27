public class ex02 {
    public static void main(String[] args) {
        System.out.println("Discount service: \n");
        DiscountService discountService = new DiscountService();
        
        Discount studentDiscount = new StudentDiscount("p2024001");
        Discount festivalDiscount = new FestivalDiscount("New Year");
        Discount loyalDiscount = new LoyalCustomerDiscount("tart1234561", 4);
        
        double price = 1000.0;
        System.out.println("Original price: $" + price);
        discountService.applyDiscount(studentDiscount, price);
        discountService.applyDiscount(festivalDiscount, price);
        discountService.applyDiscount(loyalDiscount, price);
        System.out.println();
    }
}

interface Discount {
    double calculate(double amount);
    String getDescription();
    boolean isValid();
}

class StudentDiscount implements Discount {
    String studentId;
    String university;
    boolean isVerified;
    
    public StudentDiscount(String studentId) {
        this.studentId = studentId;
        this.isVerified = true;
    }
    
    public double calculate(double amount) {
        return amount * 0.10;
    }
    
    public String getDescription() {
        return "Student Discount: 10%";
    }
    
    public boolean isValid() {
        return isVerified;
    }
}

class FestivalDiscount implements Discount {
    String festivalName;
    String startDate;
    String endDate;
    
    public FestivalDiscount(String festivalName) {
        this.festivalName = festivalName;
    }
    
    public double calculate(double amount) {
        return amount * 0.20;
    }
    
    public String getDescription() {
        return "Festival Discount: 20%";
    }
    
    public boolean isValid() {
        return true;
    }
}

class LoyalCustomerDiscount implements Discount {
    String customerId;
    int yearsWithCompany;
    int totalPurchases;
    
    public LoyalCustomerDiscount(String customerId, int years) {
        this.customerId = customerId;
        this.yearsWithCompany = years;
    }
    
    public double calculate(double amount) {
        return amount * 0.15;
    }
    
    public String getDescription() {
        return "Loyalty Discount: 15%";
    }
    
    public boolean isValid() {
        return yearsWithCompany >= 1;
    }
}

class DiscountService {
    String serviceName;
    int discountsApplied;
    double totalSavings;
    
    double calculateDiscount(Discount discount, double amount) {
        if (discount.isValid()) {
            return discount.calculate(amount);
        }
        return 0;
    }
    
    void applyDiscount(Discount discount, double amount) {
        double saved = calculateDiscount(discount, amount);
        System.out.println(discount.getDescription() + ", you saved: $" + saved);
    }
    
    double getTotalSavings() {
        return totalSavings;
    }
}