package session7;

import session7.account.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Bank {
    private String name;
    private Map<Long, BankAccount> accounts;

    public Bank(String name) throws BankException{
        if(Util.isEmpty(name)){
            throw new BankException("Bank must have a name");
        }
        this.name = name;
        accounts = new HashMap<>();
    }

    public void addAccount(BankAccount account) throws BankException {
        if(Objects.isNull(account)){
            throw new BankException("Account cannot be null");
        }
//        if(!accounts.contains(account)){
            accounts.putIfAbsent(account.getAccountNr(), account);
//        }
    }

    public BankAccount getBankAccount(long accountNr){
        return accounts.get(accountNr);
//        for (BankAccount account : accounts) {
//            if(account.getAccountNr() == accountNr){
//                return account;
//            }
//        }
//        return null;
    }

    public void printAccounts(){
        for (Long key : accounts.keySet()){
            BankAccount bankAccount = accounts.get(key);
            System.out.println(bankAccount+" "+LogManager.getLogs(bankAccount));
        }
//        for (BankAccount account : accounts) {
//            System.out.println(account);
//        }
    }

}
