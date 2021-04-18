import java.util.Stack;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.display();

        System.out.println("giá trị đã pop: " + stack.pop());
        stack.display();

        System.out.println("Giá trị bốc ra: " + stack.peek());
        stack.display();

        System.out.println("gia trị tim kiem ");
        System.out.println(stack.search(4));

    }

}
