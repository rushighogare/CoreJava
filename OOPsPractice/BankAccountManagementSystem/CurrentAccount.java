package BankAccountManagementSystem;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(){
        this.overdraftLimit=0.0;
    }

    public double getOverdraftLimit(){
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit){
        this.overdraftLimit=overdraftLimit;
    }

    public CurrentAccount(int accountNumber, String accountHolderName, double accountBalance, double overdraftLimit){
        super(accountNumber, accountHolderName, accountBalance);
        this.overdraftLimit=overdraftLimit;
    }

    @Override 
    public double calculateInterest(){
        return 0.0;  //current accounts typically do not earn interest
    }

    @Override 
    public void withdraw(double amount){
        if(amount<=getAccountBalance()+overdraftLimit){
            setAccountBalance(getAccountBalance()-amount);
            System.out.println("Withdrawal successful. New balance: "+getAccountBalance());
        } else {
            System.out.println("Withdrawal amount exceeds overdraft limit. Withdrawal failed.");
        }
    }
}
