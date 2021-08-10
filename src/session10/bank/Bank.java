package session10.bank;

import session10.bank.account.BankAccount;
import session10.bank.exception.BankException;
import session10.bank.util.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Bank {
    private String name;
    private Map<Long, BankAccount> accounts;

    public Bank(String name) throws BankException {
        if (Util.isEmpty(name)) {
            throw new BankException("Bank must have a name");
        }
        this.name = name;
        accounts = new HashMap<>();
    }

    public void addAccount(BankAccount account) throws BankException {
        if (Objects.isNull(account)) {
            throw new BankException("Account cannot be null");
        }
        accounts.putIfAbsent(account.getAccountNr(), account);
    }

    public Optional<BankAccount> getBankAccount(long accountNr) {
        return Optional.ofNullable(accounts.get(accountNr));
    }

    @Override
    public String toString() {
        return name;
    }

    public void printAccounts() {
        for (Long key : accounts.keySet()) {
            BankAccount bankAccount = accounts.get(key);
            System.out.println(bankAccount);
        }
    }

}
