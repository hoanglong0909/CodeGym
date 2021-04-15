import java.util.Stack;

    public class Tesst {
        // Đẩy phần tử lên đầu ngăn xếp
        static void stack_push(Stack<Integer> stack){
            for(int i = 0; i < 10
                    ; i++){
                stack.push(i);
        }
    }
    //Phần tử bật lên từ đầu ngăn xếp
    static void stacks(Stack<Integer> stack){
        System.out.println("Pop");
        for (int i = 0; i < 5 ; i++) {
            Integer y = (Integer) stack.pop();
            System.out.print(y + " " );
        }
    }

// Hiển thị phần tử trên đầu ngăn xếp
        static void stack_peek(Stack<Integer> stack){
            Integer element = (Integer) stack.peek();
            System.out.println("element on stack top : " + element);
        }


// Tìm kiếm phần tử trong ngăn xếp
        static void stack_search(Stack<Integer> stack, int element){
            Integer pos = stack.search(element);
            if(pos == -1)
                System.out.println("Element not found");
            else
                System.out.println("Element is found at position " + pos);
        }

        public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();
            stack_push(stack);
            stacks(stack);
            stack_push(stack);
            stack_peek(stack);
            stack_search(stack, 2);
            stack_search(stack, 3);
        }
}
