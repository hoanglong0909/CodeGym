

public class MyLinkedList<E> {
    public Node<E> head = null;
    public Node<E> tail = null;
    public int size;

    public void addFirt(E v){
        Node<E> temp;
        if(this.tail == null){
            this.tail = this.head =  new Node<>(v);
        }
        temp = this.head ;
        this.head = new Node<>(v) ;
        this.head.next = temp;
        size ++ ;
    }

    public void addLast(E v){
        Node<E> temp = new Node<>(v);
        if(this.head == null){
            this.head = this.tail = temp;
        }
        this.tail = temp;
        this.tail.next = temp;
        size ++;
    }
    public void add(int index, E value){
        if(index == 0){
            addFirt(value);
        }else if(index >= size){
            addLast(value);
        }else {
            Node<E> current = this.head ;
            for (int i = 0; i < index ; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(value) ;
            temp.next = temp;
            size++ ;
        }
    }
    public



}
