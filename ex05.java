public class ex05 {
    public static void main (String[] args){
        System.out.println("First payment method \n");
        payment p = new cash("0987654321", 20);
        shoppingCart cart1 = new shoppingCart(p);
        cart1.checkout();
        System.out.print("\n");

        System.out.println("Second payment method\n");
        payment c = new card("9337659283", 40, "0987654123456");
        shoppingCart cart2 = new shoppingCart(c);
        cart2.checkout();
        System.out.print("\n");
    }
}

interface payment {
    void pay();
    void refund();
    String getStatus();
}

class shoppingCart {
    private payment payment; 
    public shoppingCart(payment payment) {
        this.payment = payment;
    }
    
    public void checkout() {
        payment.pay();
        System.out.println("Checkout complete! Status: " + payment.getStatus());
    }
    
    public void processRefund() {
        payment.refund();
        System.out.println("Refund complete! Status: " + payment.getStatus());
    }
}

class cash implements payment{

    String transactionID;
    double amount;
    String status;

    public cash(String transactionID, double amount){
        this.transactionID = transactionID;
        this.amount = amount;
        this.status = "pending...";
    }

    @Override
    public void pay(){
        this.status = "Paid by cash";
        System.out.println("You have paid: " + amount + " $ in cash!");
        System.out.println("Your transaction ID is: " + transactionID);
    }

    @Override
    public void refund(){
        this.status = "Refunded with cash";
        System.out.println("Your refunded amount is: " + amount + " $ in cash!");
    }

    @Override
    public String getStatus(){
        return status;
    }
}


class card implements payment{

    String transactionID;
    double amount;
    String status;
    String cardNum;

    public card(String transactionID, double amount, String cardNum){
        this.transactionID = transactionID;
        this.cardNum = cardNum;
        this.amount = amount;
        this.status = "pending...";
    }

      public void pay(){
        this.status = "Paid by card";
        System.out.println("Your transaction ID is: " + transactionID);
        System.out.println(amount + " $ have been recieved from the account " + cardNum);
    }

    public void refund(){
        this.status = "Refunded via card";
        System.out.println("Your refunded amount is: " + amount + " $ via your card!");
    }

    public String getStatus(){
        return status;
    }

}



