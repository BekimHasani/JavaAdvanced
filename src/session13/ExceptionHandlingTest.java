package session13;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class ExceptionHandlingTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,20,30,40,50);
        List<Integer> list2 = Arrays.asList(1,2,3,4,5);
        list.add(2);
        int val = 0;
        processList(list, val, wrap((x,y) -> System.out.println(x/y)));
    }

    private static void processList(List<Integer> list, int value, BiConsumer<Integer, Integer> consumer){
        for (Integer num: list) {
            System.out.println("In processList method: "+num);
            consumer.accept(num, value);
        }
    }

    private static BiConsumer<Integer, Integer> wrap(BiConsumer<Integer, Integer> consumer){
        return (x,y) -> {
            try {
                System.out.println("In wrap method");
                consumer.accept(x, y);
            } catch (Exception e){
                System.out.println(e);
            }
        };
    }

}
