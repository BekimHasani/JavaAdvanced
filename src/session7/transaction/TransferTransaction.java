package session7.transaction;

import session7.BankException;
import session7.account.BankAccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TransferTransaction extends Transaction{
    private BankAccount fromAccount;
    private BankAccount toAccount;

    public TransferTransaction(BankAccount fromAccount, BankAccount toAccount) throws BankException{
        if(Objects.isNull(fromAccount)){
            throw new BankException("TransferTransaction: fromAccount is null");
        }
        if(Objects.isNull(toAccount)){
            throw new BankException("TransferTransaction: toAccount is null");
        }
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    @Override
    public void doTransaction(int amount) throws BankException {
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
        log = String.format("%s - successfully transfered %d euros to account: %d", time, amount, toAccount.getAccountNr());
    }

    @Override
    public BankAccount getBankAccount() {
        return fromAccount;
    }
}
