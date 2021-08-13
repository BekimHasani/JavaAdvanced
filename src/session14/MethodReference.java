package session14;

public class MethodReference {
    public static void main(String[] args) {
        Thread th = new Thread(MethodReference::sayHello);
        th.start();

        MethodReference mr = new MethodReference();

        Thread th1 = new Thread(mr::sayHelloShqip);
        th1.run();
    }

    private static void sayHello(){
        System.out.println("Hello from BAFF!");
    }

    private void sayHelloShqip(){
        System.out.println("Tungjatjeta nga BAFF");
    }
}
