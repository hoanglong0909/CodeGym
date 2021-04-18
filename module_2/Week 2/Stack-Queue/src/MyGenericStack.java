import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {
        stack = new LinkedList<>();
    }
    // phương thức push;
    public void push(T e){
        stack.addFirst(e);
    }
    public T pop(){
        if(stack.isEmpty()){
            throw  new EmptyStackException();
        }
        return stack.removeFirst();
    }
    // cài đặt phương thức size ;
    public int size(){
        return stack.size();
    }
    public boolean isEmpty(){
        if(stack.size()==0){
            return true;
        }
        return false;
    }

}
