package Com.Long.StackMyArrayList;

public class TestMyStackLinkedList {
    public static void main(String[] args) {
        StackMyLinkedList<Integer> stack = new StackMyLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        System.out.println("***********************************");

        System.out.println("Stack pop: " + stack.pop());
        System.out.println("***********************************");
        System.out.println("Stack peek: " + stack.peek(2));
        stack.display();
    }
}
