package session10.bank.transaction;

import session10.bank.account.BankAccount;
import session10.bank.exception.BankException;
import session10.bank.log.Loggable;

import java.util.Objects;

public abstract class Transaction implements Loggable<BankAccount> {
    protected BankAccount account;

    public Transaction(BankAccount account) throws BankException {
        if(Objects.isNull(account)){
            throw new BankException(String.format("%s: account is null", getClass().getSimpleName()));
        }
        this.account = account;
    }

    @Override
    public BankAccount getEntity() {
        return account;
    }

    public abstract String doTransaction(int amount) throws BankException;
}
