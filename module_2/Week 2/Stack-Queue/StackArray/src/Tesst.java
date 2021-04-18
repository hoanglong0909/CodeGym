public class Tesst {
    public static void main(String[] args) {
        StackArray<Integer> stack = new StackArray<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        System.out.println("****************************************");

        System.out.println("gia tri da pop " + stack.pop());
        stack.display();
        System.out.println("****************************************");

        System.out.println("gia tri da peek " + stack.peek());
        stack.display();
        System.out.println("****************************************");

        System.out.println("gia tri tim kiem" + stack.search(4));
        stack.display();







    }
}
