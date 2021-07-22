package session1;

public class Bank {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount(12345L, "Filani");
        ba1.deposit(100);
        ba1.deposit(50);
        ba1.withdraw(75);
//        System.out.println(ba1);
        System.out.println("BA1: "+System.identityHashCode(ba1));

        BankAccount ba2 = new BankAccount(12345L, "Filanja");
        System.out.println("BA2: "+System.identityHashCode(ba2));
        if(ba1.equals(ba2)){
            System.out.println("Jane te barabarte");
        } else {
            System.out.println("Nuk jane te barabarte");
        }
    }
}
