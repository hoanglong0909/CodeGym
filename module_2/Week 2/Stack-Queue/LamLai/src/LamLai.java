public class LamLai<E> {
    private int size = 0 ;
    private E[] elements;
    public static final int DEFAULT_CAPACITY = 10 ;

    public LamLai(){
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(E e){
        if(size >= DEFAULT_CAPACITY){
            System.out.println("Stack ís full");
        }else {
            elements[size] = e ;
            size ++ ;
        }
    }
    public E pop(){
        if(size <= 0 ){
            System.out.println("stack is empty ");
            return null ;
        }else {
            E temp = elements[size -1];
            elements[size - 1] = null ;
            size = size -1 ;
            return temp ;
        }
    }

    public E peek(){
        if(size <= 0 ){
            System.out.println("stack is empty ");
            return null ;
        }else {
            E temp = elements[size -1];
            return temp ;
        }
    }

    public void display(){
        for (int i = 0; i < size ; i++){
            System.out.println(elements[i]);
        }
    }
}
