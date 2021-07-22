package session5.stack;

public class Stack {
    private int[] data;
    private int index;

    public Stack(int size) throws StackException {
        if(size < 1){
            throw new StackException("Stack should hold at least one value");
        }
        data = new int[size];
    }

    public void push(int value) throws PushException{

        if(index == data.length){
            throw new PushException("PUSH: No more space");
        }
        data[index++] = value;
    }

    public int pop() throws PopException{
        if(index > 0) {
            return data[--index];
        }
        throw new PopException("POP: No data");
    }
}
