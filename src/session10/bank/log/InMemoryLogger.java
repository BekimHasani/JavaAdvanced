package session10.bank.log;

import session10.bank.account.BankAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryLogger implements Logger<BankAccount>{
    private Map<BankAccount, List<String>> logs;

    public InMemoryLogger(){
        logs = new HashMap<>();
    }

    @Override
    public void writeLog(Loggable<BankAccount> loggable, String action) throws Exception {
        logs.putIfAbsent(loggable.getEntity(), new ArrayList<>());
        logs.get(loggable.getEntity()).add(action);
    }

    @Override
    public List<String> getLogs(BankAccount entity) throws Exception {
        return logs.getOrDefault(entity, new ArrayList<>(0));
    }
}
