package session5.stack;

public class StackTest {
    public static void main(String[] args) {
        try {
            Stack stack = new Stack(3);
            stack.push(-9999);
            stack.push(2);
            stack.push(3);
//            stack.push(4);
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
        }
        catch(PopException | PushException pe){ //if you treat exceptions the same way
            pe.printStackTrace();
        }
//        catch(PushException pe){
//            System.out.println(pe.getMessage());
//        }
//        catch(PopException pe){
//            pe.printStackTrace();
//        }
        catch (StackException e){
            System.out.println(e);
        } finally{
            System.out.println("FINALLY ....");
        }
    }
}
