package session13;

@FunctionalInterface
public interface Hello {
    void sayHello();
    default void test(){
        System.out.println("This is a test method!!");
    }
}
