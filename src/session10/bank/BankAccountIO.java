package session10.bank;

import session10.bank.account.BankAccount;
import session10.bank.exception.BankException;
import session10.bank.log.Logger;
import session10.bank.log.LoggerFactory;
import session10.bank.transaction.DepositTransaction;
import session10.bank.transaction.Transaction;
import session10.bank.transaction.TransferTransaction;
import session10.bank.transaction.WithdrawTransaction;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class BankAccountIO {
    private BankAccountInterface bankAccountInterface;
    private Scanner scanner;
    private Logger logger;

    public BankAccountIO(BankAccountInterface bankAccountInterface) throws BankException {
        if(Objects.isNull(bankAccountInterface)){
            throw new BankException("Interface to the bank cannot be null");
        }
        this.bankAccountInterface = bankAccountInterface;
        scanner = new Scanner(System.in);
//        logger = new FileLogger();
        logger = LoggerFactory.getLogger("IN_MEMORY");
    }

    public void doStart() throws Exception {
        System.out.printf("Welcome to %s%n",bankAccountInterface.getBank());
        BankAccount bankAccount = getBankAccount();
        int operation;
        do {
            operation = getOperation();
            switch (operation) {
                case 4:
                    System.out.printf("%s%n", bankAccount);
                    break;
                case 5:
                    List<String> logs = logger.getLogs(bankAccount);
                    for (String log: logs) {
                        System.out.println(log);
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    int amount = getAmount();
                    Transaction transaction = getTransaction(operation, bankAccount);
                    logger.writeLog(transaction,
                            String.format("[%s] %s",bankAccountInterface.getId(), transaction.doTransaction(amount)));
            }
        } while (operation != 0);
        System.out.printf("Thank you for doing business with %s",bankAccountInterface.getBank());
    }

    private Transaction getTransaction(int transactionType, BankAccount bankAccount) throws BankException {
        switch(transactionType){
            case 1:
                return new WithdrawTransaction(bankAccount);
            case 2:
                return new DepositTransaction(bankAccount);
            case 3:
                System.out.println("Please get the account to transfer the amount");
                BankAccount toBankAccount = getBankAccount();
                return new TransferTransaction(bankAccount, toBankAccount);
            default:
                return null;
        }
    }

    private int getAmount(){
        System.out.printf("Please enter transaction amount [MIN: %d] ", bankAccountInterface.MINIMUM_AMOUNT);
        int amount = 0;
        while(!scanner.hasNextInt() || (amount = scanner.nextInt()) <  bankAccountInterface.MINIMUM_AMOUNT){
            scanner.nextLine();
            System.out.printf("Please enter transaction amount [MIN: %d] ", bankAccountInterface.MINIMUM_AMOUNT);
        }
        return amount;
    }

    private int getOperation(){
        System.out.print("Press:\n0 - Exit\n1 - Withdraw\n2 - Deposit\n3 - Transfer\n4 - Balanace\n5 - List transactions\n");
        int type = -1;
        while(!scanner.hasNextInt() || (type = scanner.nextInt()) < 0 || type > 5){
            scanner.nextLine();
            System.out.print("Press:\n0 - Exit\n1 - Withdraw\n2 - Deposit\n3 - Transfer\n4 - Balanace\n5 - List transactions\n");
        }
        return type;
    }

    private BankAccount getBankAccount(){
        long accountNr = getAccountNumber();
        Optional<BankAccount> bankAccountOptional = bankAccountInterface.getBankAccount(accountNr);
        return bankAccountOptional.orElseGet(this::getBankAccount);
    }

    private long getAccountNumber(){
        System.out.print("Enter your account number: ");
        long accountNr = 0;
        while(!scanner.hasNextLong() || (accountNr = scanner.nextLong()) <= 0){
            scanner.nextLine();
            System.out.print("Please enter a valid account number: ");
        }
        return accountNr;
    }
}
