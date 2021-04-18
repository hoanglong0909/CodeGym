import java.util.Arrays;

public class MyStackArray<E> {
    private int size = 0 ;
    private E[] elements ;
//    public final int DEFAULT_SIZE =10 ;


    public MyStackArray(E e){

        elements = (E[]) new Object[2];
    }
    public boolean isEmpty(){
        return size == 0 ? true : false ;
    }


    public void push(E e){
        ensureCapa();
        elements[size] = e ;
        size ++;
    }


    public E pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty ");
            return null;
        }
        size--;
        return elements[size] ;

    }

    public E peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty ");
            return null;
        }
        return elements[size-1] ;
    }


    public void display(){
        if(isEmpty()){
            System.out.println("Empty");
        }
        for (int i = 0; i <size ; i++) {
            System.out.println(elements[i]);
        }
    }
    public int search(E e){
        for (int i = 0; i < size; i++) {
            if(e == elements[i] ){
                return i ;
            }
        }
        return -1;
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }


    public static void main(String[] args) {
        MyStackArray<Integer> stack = new MyStackArray<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();


        System.out.println("Stack Pop: " +stack.pop());
        stack.display();
        System.out.println("*******************************************");

        System.out.println("Stack Peek: " +stack.peek());
        stack.display();
        System.out.println("*******************************************");


        System.out.println("Stack Peek: " +stack.search(8));
        stack.display();








    }

}
