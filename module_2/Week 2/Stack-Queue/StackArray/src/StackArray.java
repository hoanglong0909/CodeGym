import java.util.Arrays;

public class StackArray<E> {
//    public static final int DEFAULT_CAPACITY = 10 ;
    private int size = 0;
    private E[] elements;

    public StackArray(){
        this.elements = (E[]) new Object[2];
    }


    public void push(E e){
        if(size < elements.length){
            ensuareCapa();
        }
            elements[size] = e ;
            size ++ ;
    }
    public E pop(){
        if(size < 0){
            System.out.println("NO is Stack: ");
            return null ;

        }
            E temp = elements[size -1];
            elements[size-1] = null ;
            size = size-1 ;
            return  temp ;

    }
    public E peek(){
        if(size <= 0) {
            System.out.println("No is number peek");
            return null;
        }
            E temp = elements[size- 1];
            return temp;

    }
    public int search(E e){
        for (int i = 0; i <size ; i++) {
            if(elements[i] == e){
                return i;
            }
        }return -1;
    }
    public void display(){
        for (int i = 0; i < size ; i++) {
            System.out.println(elements[i]);
        }
    }
    public void ensuareCapa(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize) ;
    }

}


