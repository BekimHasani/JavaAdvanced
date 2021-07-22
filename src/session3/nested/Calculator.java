package session3.nested;

public class Calculator {
    private Addition addition;
    public int add(int x, int y){
        class Add extends Addition{
            @Override
            public int add(){
                return x+y;
            }
        }

        addition = new Add();
        return addition.add();
    }

    public int testAddition(){
        return addition.add();
    }
}
