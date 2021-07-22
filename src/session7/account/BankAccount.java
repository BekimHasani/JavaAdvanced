package session7.account;

import session7.BankException;

import java.util.Objects;

public abstract class BankAccount {
    private long accountNr;
    private String name;
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

    public void deposit(int amount) throws BankException {
        if (amount <= 0) {
            throw new BankException(String.format("DEPOSIT: Amount must be positive [%d]", amount));
        }
        balance += amount;
    }

    public void withdraw(int amount) throws BankException {
        if (amount <= 0) {
            throw new BankException(String.format("WITHDRAW: Amount must be positive [%d]", amount));
        }

        if (amount > getBalance()) {
            throw new BankException(String.format("WITHDRAW: Insufficient amount. Balance: %.2f, amount: %d", getBalance(), amount));
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("%s - [%d] %s: %.2f", getClass().getSimpleName(), accountNr, name, getBalance());
    }

    public boolean equals(Object obj) {
        if (obj instanceof BankAccount) {
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
