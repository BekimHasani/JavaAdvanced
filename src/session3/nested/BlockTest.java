package session3.nested;

public class BlockTest {
    public BlockTest(){
        System.out.println("Ne konstruktore");
    }

    static {
        System.out.println("Ne bllok static");
    }

    {
        System.out.println("Initialising block");
    }

    public static void main(String[] args) {
        System.out.println("Ne metoden main");
        new BlockTest();
    }

    static {
        System.out.println("Ne bllok static2");
    }

    {
        System.out.println("Initialising block2");
    }
}
