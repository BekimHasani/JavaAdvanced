package session10.bank;

import session10.bank.account.BankAccount;
import session10.bank.exception.BankException;
import session10.bank.transaction.Transaction;

import java.util.Optional;

public interface BankAccountInterface {
    int MINIMUM_AMOUNT = 10;
    Bank getBank();
    String getId();
    Optional<BankAccount> getBankAccount(long accountNr);
    String doTransaction(Transaction transaction, int amount) throws BankException;
}
