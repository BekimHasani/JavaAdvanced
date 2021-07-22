package session7;

import session7.account.BankAccount;
import session7.transaction.Loggable;

import java.util.*;

public class LogManager {
    private static Map<BankAccount, List<String>> transactionLog;

    static {
        transactionLog = new Hashtable<>();
    }

    public static void addLog(Loggable loggable){
        System.out.println("loggable.getBankAccount().hashCode() = " + loggable.getBankAccount().hashCode());
        transactionLog.putIfAbsent(loggable.getBankAccount(), new ArrayList<>());
        transactionLog.get(loggable.getBankAccount()).add(loggable.getLog());
    }

    public static List<String> getLogs(BankAccount bankAccount){
        return transactionLog.get(bankAccount);
    }
}
