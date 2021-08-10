package session10.bank.transaction;

import session10.bank.account.BankAccount;
import session10.bank.exception.BankException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DepositTransaction extends Transaction {
    public DepositTransaction(BankAccount account) throws BankException {
        super(account);
    }

    @Override
    public String doTransaction(int amount) throws BankException {
        account.deposit(amount);
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
        return String.format("%s - successfully deposited %d euros", time, amount);
    }
}
