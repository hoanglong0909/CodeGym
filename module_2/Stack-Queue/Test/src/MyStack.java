import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class MyStack<E> {
//    public static final int DEFAULT_CAPACITY = 2 ;
    private  int size=0 ;
    private E[] elements ;



    public MyStack() {
        this.elements = (E[]) new Object[2];
    }
    public void push(E e){

        if (size == elements.length)
             {
                ensureCapa();


        }
            elements[size] = e;
            size++ ;

    }
    public E pop(){
        if(size<= 0 ){
            System.out.println("stack is empty");
            return null;
        }
        E temp = elements[size-1] ;
        elements[size-1] = null;
        size = size -1 ;
        return temp ;
    }
    public E peek(){
        if(size<= 0 ){
            System.out.println("stack is empty");
            return null;
        }
        E temp = elements[size-1] ;
        return temp ;
    }

    public void display(){
        for (int i = 0; i < size ; i++) {
            System.out.println(elements[i]);
        }
    }


    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}
