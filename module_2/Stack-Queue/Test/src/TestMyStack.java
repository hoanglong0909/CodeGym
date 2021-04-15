import java.util.Stack;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(6);
        stack.display();
        System.out.println("Giá trị bốc ra: " + stack.peek());

        stack.display();


    }

}
