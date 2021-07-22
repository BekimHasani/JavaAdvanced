package session7.transaction;

import session7.BankException;

public abstract class Transaction implements Loggable{
    protected String log;

    @Override
    public String getLog(){
        return log;
    }

    public abstract void doTransaction(int amount) throws BankException;
}
