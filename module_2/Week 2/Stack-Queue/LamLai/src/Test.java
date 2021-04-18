import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        LamLai<Integer> stack = new LamLai<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.display();


        System.out.println( "stack is number: " + stack.pop());
        stack.display();


        System.out.println( "stack is number peek : " + stack.peek());
        stack.display();

//        Stack<Integer> stack1 = new Stack<>();
//        stack1.peek();
//        stack.peek();

    }
}
