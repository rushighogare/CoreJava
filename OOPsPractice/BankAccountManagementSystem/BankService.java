package BankAccountManagementSystem;

public interface BankService {
    public void createSavingsAccount(int accountNumber, String accountHolderName, double accountBalance, double interestRate);
    
    public void createCurrentAccount(int accountNumber, String accountHolderName, double accountBalance, double overdraftLimit);

    public void getAccountDetails(int accountNumber);

    public void displayAllAccounts();

    public void deposit(int accountNumber, double amount);

    public void withdraw(int accountNumber, double amount);

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount);

    public void deleteAccount(int accountNumber);
}
