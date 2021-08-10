package session10.bank;

import session10.bank.account.BankAccount;
import session10.bank.account.CurrentAccount;
import session10.bank.account.SavingsAccount;
import session10.bank.exception.BankException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BankTest {

    private static Set<BankAccount> readFromFile(String path) throws IOException, BankException {
        //File file = new File(path);
        final List<String> accountString = Files.readAllLines(Paths.get(path));
        Set<BankAccount> accounts = new HashSet<>(accountString.size());
        for (String account : accountString) {
            try {
                BankAccount bankAccount = fromString(account);
                if (Objects.nonNull(bankAccount)) {
                    accounts.add(bankAccount);
                }
            } catch(Exception e){
//                e.printStackTrace();
//                System.out.println(e.getMessage());
            }
        }
        return accounts;
    }

    private static BankAccount fromString(String account) throws BankException {
        String [] params = account.split(":");
        BankAccount bankAccount = null;
        if(params.length == 4){
            Long accountNr = Long.valueOf(params[1]);
            String name = params[2];

            switch(params[0].toUpperCase()){
                case "S":
                    Double interest = Double.valueOf(params[3]);
                    bankAccount = new SavingsAccount(accountNr, name, interest);
                    break;
                case "C":
                    Integer overdraft = Integer.valueOf(params[3]);
                    bankAccount = new CurrentAccount(accountNr, name, overdraft);
                    break;
                default:
                    new BankException("Bank account type not supported!");
            }
        }
        return bankAccount;
    }

    public static void main(String[] args) {
        try {
            Bank bank = new Bank("BAFF Bank");
            Set<BankAccount> accounts = readFromFile("C:\\Users\\BekimH\\Desktop\\accounts.txt");
            for (BankAccount account : accounts) {
                bank.addAccount(account);
            }
//            bank.printAccounts();
            BankAccountInterface bankAccountInterface = new Atm("001", bank);
            new BankAccountIO(bankAccountInterface).doStart();
        } catch (Exception be){
            be.printStackTrace();
        }
    }
}
