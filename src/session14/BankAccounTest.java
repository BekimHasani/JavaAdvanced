package session14;

import session7.Bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BankAccounTest {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>(List.of(
                new BankAccount(123546L, "Filani", 500),
                new BankAccount(654321L, "Filanja", 1000),
                new BankAccount(654789L, "Dema", 150),
                new BankAccount(123789L, "John", 200)
        ));


        Collections.sort(accounts, Comparator.comparing(BankAccount::getBalance).reversed());
//        Collections.sort(accounts, Comparator.naturalOrder());

//        Collections.sort(accounts, (o1, o2) -> {
//                if(o1.getBalance() == o2.getBalance()){
//                    return 0;
//                }
//                return o1.getBalance() < o2.getBalance() ? -1 : 1;
//        });

        print(accounts, ba -> ba.getBalance() >= 500, ba -> System.out.printf("%s has [%.2f]%n", ba.getName(), ba.getBalance()));
        System.out.println("------------------");
        print(accounts, ba -> ba.getBalance() >= 200, System.out::println);
    }

    private static void print(List<BankAccount> accounts, Predicate<BankAccount> condition, Consumer<BankAccount> consumer){
        for (BankAccount account : accounts) {
            if(condition.test(account)) {
                consumer.accept(account);
            }
        }
    }
}
