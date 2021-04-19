package Com.Long.StackLinkedList;

public class TestStackLinkedList {
    private static void stackOfIStrings() {
        StackLinkedList<String> stack = new StackLinkedList();
        stack.push("Nam");
        stack.push("Long");
        stack.push("Tam");
        stack.push("hai");
        stack.push("thien");
        System.out.println("1 Size of stack after push operations: " + stack.size());
        System.out.printf("2. Pop elements from stack : ");
        while (!stack.isEmpty()) {
            System.out.printf(" %s", stack.pop());
        }
        System.out.println("\n.3. Size of stack after pop operations : " + stack.size());
    }
    public static void main(String[] args) {
        System.out.println("\n2. Stack of Strings");
        stackOfIStrings();
    }
}

