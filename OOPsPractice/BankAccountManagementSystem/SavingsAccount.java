package BankAccountManagementSystem;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(){
        this.interestRate=0.0;
    }

    public SavingsAccount(int accountNumber, String accountHolderName, double accountBalance, double interestRate){
        super(accountNumber, accountHolderName, accountBalance);
        this.interestRate=interestRate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public void setInterestRate(double interestRate){
        this.interestRate=interestRate;
    }

    @Override 
    public double calculateInterest(){
        double interest = (getAccountBalance() * interestRate) / 100;
        return interest;
    }

    @Override 
    public void withdraw(double amount){
        //minimum balance rule
        if(amount<=getAccountBalance() && getAccountBalance()-amount>=1000){
            setAccountBalance(getAccountBalance()-amount);
            System.out.println("Withdrawal successful. New balance: "+getAccountBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }
}
