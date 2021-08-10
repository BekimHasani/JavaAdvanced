package session10.bank.account;


import session10.bank.exception.BankException;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(long accountNr, String name, double interestRate) throws BankException {
        super(accountNr, name);
        this.interestRate = interestRate;
    }

    @Override
    public double getBalance() {
        return super.getBalance() * (1 + interestRate/100);
    }
}
