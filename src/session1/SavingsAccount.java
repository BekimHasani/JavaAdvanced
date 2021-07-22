package session1;

public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(long accountNr, String name, double interestRate) {
        super(accountNr, name);
        this.interestRate = interestRate;
    }

    @Override
    public double getBalance() {
        return super.getBalance() * (1 + interestRate/100);
    }
}
