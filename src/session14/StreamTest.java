package session14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>(List.of(
                new BankAccount(123546L, "Filani", 500),
                new BankAccount(654321L, "Filanja", 1000),
                new BankAccount(654789L, "Dema", 150),
                new BankAccount(123789L, "John", 200)
        ));

        final Set<BankAccount> filteredBankAccounts = accounts.stream()
                .filter(bankAccount -> bankAccount.getBalance() >= 200)
                .filter(bankAccount -> bankAccount.getName().startsWith("F"))
                .collect(Collectors.toSet());

        IntStream.rangeClosed(1, 30)
                .skip(10)
                .filter(n -> n % 2 == 0)
                .filter(n -> n >= 20)
                .map(n -> n + 45)
                .mapToObj(n -> (char)n) //metoda map po e trajton stream(char) si stream(int)
                .forEach(System.out::println);

//        final Stream<BankAccount> stream = accounts.stream();

//        final Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6);
//        System.out.println(IntStream.rangeClosed(1, 30)
//                .skip(10)
//                .filter(n -> n % 2 == 0)
//                .filter(n -> n >= 20)
//                .map(n -> n + 45)
//                .summaryStatistics()
//                .getMax());
//        System.out.printf("Sum: %d", sum);
//
//        final IntStream range = IntStream.rangeClosed(1, 10);
//
//        final DoubleStream doubleStream = DoubleStream.iterate(1, a -> a < 100, a -> a + 1.5);
//
//        final Stream<Integer> iterateStream = Stream.iterate(1, a -> a < 50, a -> a + 1);
//        iterateStream
//            .limit(10)
//            .skip(5)
//            .forEach(System.out::println);

    }

}
