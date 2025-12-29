public class ex03 {
    public static void main(String[] args) {
        System.out.println("Bank account service: \n");
        SavingsAccount savings = new SavingsAccount("lyda2468");
        savings.deposit(1000);
        savings.withdraw(200);
        System.out.println("Savings balance: $" + savings.getBalance());
        
        FixedDepositAccount fd = new FixedDepositAccount("FD001", "2026-12-31");
        fd.deposit(5000);
        System.out.println("Fixed deposit balance: $" + fd.getBalance());
        System.out.println();
    }
}

abstract class BankAccount {
    String accountNumber;
    double balance;
    String accountType;
    
    public BankAccount(String accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.accountType = accountType;
    }
    
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }
    
    double getBalance() {
        return balance;
    }
    
    String getAccountType() {
        return accountType;
    }
}

abstract class WithdrawableAccount extends BankAccount {
    double withdrawalLimit;
    int withdrawalCount;
    
    public WithdrawableAccount(String accountNumber, String accountType) {
        super(accountNumber, accountType);
    }
    
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            withdrawalCount++;
            System.out.println("Withdrawn: $" + amount);
        }
    }
    
    void setWithdrawalLimit(double limit) {
        this.withdrawalLimit = limit;
    }
}

class SavingsAccount extends WithdrawableAccount {
    double interestRate;
    
    public SavingsAccount(String accountNumber) {
        super(accountNumber, "Savings");
        this.interestRate = 0.03;
    }
    
    void calculateInterest() {
        double interest = balance * interestRate;
        deposit(interest);
    }
}

class FixedDepositAccount extends BankAccount {
    double interestRate;
    
    public FixedDepositAccount(String accountNumber, String maturityDate) {
        super(accountNumber, "Fixed Deposit");
        this.interestRate = 0.06;
    }
}