package session13;

public class ThisTest {
    private void calculate(Calculate calculate, int x){
        calculate.doCalculate(x);
    }

    public void doCalculate(int x){
//        calculate(new Calculate() {
//            @Override
//            public void doCalculate(int i) {
//                System.out.println("Value of i = "+i);
//                System.out.println(this);
//            }
//
//            @Override
//            public String toString() {
//                return "This is a anonyomous instance";
//            }
//        }, x);
        calculate(i -> {
            System.out.println("Value of i = "+i);
            System.out.println(this);
        }, x);
    }

    public static void main(String[] args) {
        ThisTest test = new ThisTest();
        int a = 100;
        test.doCalculate(a);

//        test.doCalculate(a);
    }

    @Override
    public String toString() {
        return "This is ThisTest instance";
    }
}

interface Calculate {
    void doCalculate(int i);
}
