package session14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankAccountParser {
    public static void main(String[] args) throws IOException {
        final Set<BankAccount> list = Files.lines(Paths.get("D:/Training/bank/data/accounts.txt"))
                .map(line -> line.split(":"))
                .filter(array -> array.length == 4)
                .filter(array -> Stream.of("C", "S").anyMatch(value -> value.equals(array[0])))
                .filter(array -> isValidAccountNumber(array[1]))
                .map(BankAccountParser::toBankAccount)
                .collect(Collectors.toSet());//.forEach(array -> System.out.println(Arrays.toString(array)))
//                .forEach(System.out::println)
    }

    private static BankAccount toBankAccount(String [] str){
        return null;
    }

    private static boolean isValidAccountNumber(String value){
        try {
            return Long.parseLong(value) >= 1000;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
