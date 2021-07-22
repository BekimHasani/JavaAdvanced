package session7.transaction;

import session7.account.BankAccount;

public interface Loggable {
    public BankAccount getBankAccount();
    public String getLog();
}
