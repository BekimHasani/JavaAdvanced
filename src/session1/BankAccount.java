package session1;

import java.util.Objects;

public class BankAccount {
    private long accountNr = 0;
    private String name = null;
    private double balance;

    public BankAccount(long accountNr, String name) {
        this.accountNr = accountNr;
        this.name = name;
    }

    public BankAccount(long accountNr, String name, double balance) {
        this.accountNr = accountNr;
        this.name = name;
        this.balance = balance;
    }

    public long getAccountNr() {
        return accountNr;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String deposit(int amount){
        if(amount <= 0){
            return String.format("DEPOSIT: Amount must be positive [%d]", amount);
        }
        balance += amount;
        return String.format("DEPOSIT: Amount [%d] deposited successfully", amount);
    }

    public String withdraw(int amount){
        if(amount <= 0){
            return String.format("WITHDRAW: Amount must be positive [%d]", amount);
        }

        if(amount > balance){
            return String.format("WITHDRAW: Insufficient amount. Balance: %.2f, amount: %d, diff: %.2f",
                    balance, amount, amount - balance);
        }
        balance -= amount;
        return String.format("WITHDRAW: Amount [%d] withdrawn successfully", amount);
    }

    @Override
    public String toString(){
        return String.format("[%d] %s: %.2f%n", accountNr, name, balance);
    }

    public boolean equals(Object obj){
        if(obj instanceof BankAccount){
            BankAccount acc = (BankAccount) obj;
            return accountNr == acc.getAccountNr();
        }
        return false;
    }

    @Override
    public int hashCode() {
       return Objects.hash(accountNr);
    }

}
