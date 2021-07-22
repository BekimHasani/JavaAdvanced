package session7;

import session7.account.BankAccount;
import session7.account.CurrentAccount;
import session7.account.SavingsAccount;
import session7.transaction.DepositTransaction;
import session7.transaction.Transaction;
import session7.transaction.TransferTransaction;
import session7.transaction.WithdrawTransaction;

public class BankTest {
    public static void main(String[] args) {
        try {
            Bank bank = new Bank("BAFF Bank");
            CurrentAccount account = new CurrentAccount(123546L, "Filani", 500);
            bank.addAccount(account);
            bank.addAccount(new CurrentAccount(12344L, "Filanja", 1000));
//            bank.addAccount(new SavingsAccount(125478L, "John", 5.0));
//            bank.addAccount(new SavingsAccount(125478L, "John", 5.0));

            final BankAccount bankAccount1 = bank.getBankAccount(123546L);
//            bankAccount1.deposit(500);
//            bank.getBankAccount(12344L).deposit(300);
            final BankAccount bankAccount2 = bank.getBankAccount(12344L);
//            bankAccount2.withdraw(150);
            bank.printAccounts();
            System.out.println("======================================");
            Transaction trnBA1 = new DepositTransaction(bankAccount1);
            trnBA1.doTransaction(430);
            LogManager.addLog(trnBA1);
            Transaction trnBA2 = new WithdrawTransaction(bankAccount2);
            trnBA2.doTransaction(150);
            LogManager.addLog(trnBA2);
            Transaction trnTr2 = new TransferTransaction(bankAccount1, bankAccount2);
            trnTr2.doTransaction(400);
            LogManager.addLog(trnTr2);
            bank.printAccounts();
//            CurrentAccount account1 = new CurrentAccount(123546L, "Filani", 500);
//            System.out.println("ACCOUNT1: "+LogManager.getLogs(account1));
        } catch (BankException be){
            be.printStackTrace();
        }
    }
}
