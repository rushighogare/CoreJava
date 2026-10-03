package BankAccountManagementSystem;

public abstract class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double accountBalance;

    public BankAccount(){
        this.accountNumber=0;
        this.accountHolderName="";
        this.accountBalance=0.0;
    }

    public BankAccount(int accountNumber, String accountHolderName, double accountBalance){
        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        this.accountBalance=accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void deposit(double amount){
        this.accountBalance+=amount;
    }

    public void displayAccountDetails(){
        System.out.println("Account Number: "+this.accountNumber);
        System.out.println("Account Holder Name: "+this.accountHolderName);
        System.out.println("Account Balance: "+this.accountBalance);
    }

    public abstract double calculateInterest();

    public abstract void withdraw(double amount);
}
