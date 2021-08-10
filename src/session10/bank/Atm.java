package session10.bank;

import session10.bank.account.BankAccount;
import session10.bank.exception.BankException;
import session10.bank.transaction.Transaction;
import session10.bank.util.Util;

import java.util.Objects;
import java.util.Optional;

public class Atm implements BankAccountInterface{
    private String code;
    private Bank bank;

    public Atm(String code, Bank bank) throws BankException {
        if(Util.isEmpty(code)){
            throw new BankException("Code of ATM cannot be empty!");
        }
        if(Objects.isNull(bank)){
            throw new BankException("ATM must belong to a bank");
        }
        this.code = code;
        this.bank = bank;
    }



    @Override
    public Bank getBank() {
        return bank;
    }

    @Override
    public String getId() {
        return "ATM: "+code;
    }

    @Override
    public Optional<BankAccount> getBankAccount(long accountNr) {
        return bank.getBankAccount(accountNr);
    }

    @Override
    public String doTransaction(Transaction transaction, int amount) throws BankException {
        return transaction.doTransaction(amount);
    }
}
