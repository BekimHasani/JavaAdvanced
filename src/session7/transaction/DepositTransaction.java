package session7.transaction;

import session7.BankException;
import session7.account.BankAccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DepositTransaction extends Transaction{
    private BankAccount account;

    public DepositTransaction(BankAccount account) throws BankException{
        if(account == null){
            throw new BankException("DepositTransaction: account is null");
        }
        this.account = account;
    }



    @Override
    public void doTransaction(int amount) throws BankException {
        account.deposit(amount);
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
        log = String.format("%s - successfully deposited %d euros", time, amount);
    }

    @Override
    public BankAccount getBankAccount() {
        return account;
    }
}
