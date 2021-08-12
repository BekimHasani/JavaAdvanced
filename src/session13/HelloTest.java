package session13;

public class HelloTest {
    public static void main(String[] args) {
        HelloTest test = new HelloTest();
        Hello english = new HelloEnglish();
        test.sayHello(english);
        Hello shqip = new Hello() {
            @Override
            public void sayHello() {
                System.out.println("Tungjatjeta nga BAFF");
            }

            @Override
            public void test(){}
        };
        test.sayHello(shqip);

        Hello german = () -> System.out.println("Hallo von BAFF");
        test.sayHello(german);

        Runnable runnable = () -> System.out.println("Tungjatjeta nga BAFFWORKS");
        runnable.run();
    }

    private void sayHello(Hello hello){
        hello.sayHello();
    }
}
