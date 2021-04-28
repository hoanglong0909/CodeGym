import java.util.*;

public class exception1 {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<Integer>();
        for (int i = 1; i <= 10; i = i + 2) {
            myStack.push(i);
        }

        if (myStack.contains(9)) {
            myStack.pop();
        }

        System.out.println(myStack.peek());

    }



    }



