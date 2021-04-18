import java.util.LinkedList;
import java.util.Stack;

public class MyStack<E> {

    private LinkedList<E> elements ;

    public MyStack(){
        elements = new LinkedList<>();
    }

    public boolean isEmpty(){
        return elements.size() == 0 ? true: false ;
    }

    public void  push(E e){
        elements.addLast(e);
    }

    public E pop(){
        return elements.removeFirst();
    }

    public E peek(){
        return elements.getLast();
    }


    public void display(){
        for (int i = 0; i < elements.size() ; i++) {
            System.out.println(elements.get(i));

        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.display();

        System.out.println("stack Pop :" + stack.pop());
        stack.display();

        System.out.println("stack peek :" + stack.peek());
        stack.display();


    }


}
