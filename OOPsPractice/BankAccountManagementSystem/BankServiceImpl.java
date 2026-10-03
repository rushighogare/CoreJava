package BankAccountManagementSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankServiceImpl implements BankService {
    List<BankAccount> accounts;

    public BankServiceImpl(){
        accounts=new ArrayList<>();
    }

    @Override
    public void createSavingsAccount(int accountNumber, String accountHolderName, double accountBalance, double interestRate) {
        BankAccount account=new SavingsAccount();
        account.setAccountNumber(accountNumber);
        account.setAccountHolderName(accountHolderName);
        account.setAccountBalance(accountBalance);
        ((SavingsAccount) account).setInterestRate(interestRate);

        accounts.add(account);
    }

    @Override
    public void createCurrentAccount(int accountNumber, String accountHolderName, double accountBalance, double overdraftLimit) {
        BankAccount account=new CurrentAccount();
        account.setAccountNumber(accountNumber);
        account.setAccountHolderName(accountHolderName);
        account.setAccountBalance(accountBalance);
        ((CurrentAccount) account).setOverdraftLimit(overdraftLimit);

        accounts.add(account);
    }

    public void getAccountDetails(int accountNumber) {
        for(BankAccount b:accounts){
            if(b.getAccountNumber()==accountNumber){
                b.displayAccountDetails();
                return ;
            }
        }

        System.out.println("Account not found.");
    }

    @Override
    public void displayAllAccounts() {
        for(BankAccount b:accounts){
            b.displayAccountDetails();
            System.out.println("Interest: "+b.calculateInterest());
            System.out.println("---------------------------");
        }
    }

    @Override
    public void deposit(int accountNumber, double amount) {
        for(BankAccount b:accounts){
            if(b.getAccountNumber()==accountNumber){
                b.deposit(amount);
                System.out.println("Deposit successful. New balance: "+b.getAccountBalance());
                return ;
            }
        }

        System.out.println("Account not found.");
    }

    @Override
    public void withdraw(int accountNumber, double amount) {
        for(BankAccount b:accounts){
            if(b.getAccountNumber()==accountNumber){
                b.withdraw(amount);
                return ;
            }
        }

        System.out.println("Account not found.");
    }

    @Override
    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount=null;
        BankAccount toAccount=null;

        for(BankAccount b:accounts){
            if(b.getAccountNumber()==fromAccountNumber){
                fromAccount=b;
            }
            if(b.getAccountNumber()==toAccountNumber){
                toAccount=b;
            }
        }

        if(fromAccount==null || toAccount==null){
            System.out.println("One or both accounts not found. Transfer failed.");
            return ;
        }

        if(fromAccount.getAccountBalance()>=amount){
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transfer successful. New balance of from account: "+fromAccount.getAccountBalance());
            System.out.println("New balance of to account: "+toAccount.getAccountBalance());
        }
        else{
            System.out.println("Insufficient balance in from account. Transfer failed.");
        }
    }

    @Override
    public void deleteAccount(int accountNumber) {
        Iterator<BankAccount> it=accounts.iterator();

        while(it.hasNext()){
            BankAccount b=it.next();
            if(b!=null && b.getAccountNumber()==accountNumber){
                it.remove();
                System.out.println("Account deleted successfully.");
                return ;
            }
        }

        System.out.println("Account not found.");
    }
    
    public static void main(String[] args){
        BankServiceImpl bs=new BankServiceImpl();

        bs.createSavingsAccount(1, "John Doe", 5000, 5);
        bs.createSavingsAccount(2, "Jane Smith", 3000, 4);
        bs.createCurrentAccount(3, "Alice Johnson", 2000, 1000);

        bs.displayAllAccounts();
        System.out.println("Depositing 1000 to account 1");
        bs.deposit(1, 1000);
        bs.getAccountDetails(1);

        System.out.println("Withdrawing 2000 from account 2");
        bs.withdraw(2, 2000);
        bs.getAccountDetails(2);

        bs.transferMoney(1, 2,  2500);
    }
}
