package session10.bank.transaction;

import session10.bank.account.BankAccount;
import session10.bank.exception.BankException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TransferTransaction extends Transaction {
    private BankAccount toAccount;

    public TransferTransaction(BankAccount account, BankAccount toAccount) throws BankException {
        super(account);
        if(Objects.isNull(toAccount)){
            throw new BankException("TransferTransaction: toAccount is null");
        }
        this.toAccount = toAccount;
    }

    @Override
    public String doTransaction(int amount) throws BankException {
        account.withdraw(amount);
        toAccount.deposit(amount);
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
        return String.format("%s - successfully transferred %d euros to account: %d", time, amount, toAccount.getAccountNr());
    }

}
