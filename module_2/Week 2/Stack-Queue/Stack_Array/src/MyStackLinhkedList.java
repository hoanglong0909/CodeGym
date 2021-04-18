import org.w3c.dom.Node;

public class MyStackLinhkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    public class Node<E> {
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    public MyStackLinhkedList(){
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty(){
        return this.head == null ? true: false;
    }

    public void push(E e){
        Node<E> temp = new Node<E>(e);
        if (isEmpty()){
            this.head = this.tail = temp;
        }
        this.tail.next = temp;
        this.tail =temp ;
    }


    public E pop(){
        Node temp = head;
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }
        while (temp.next.next!=null){
            temp=temp.next;
        }
        temp.next = null;
        return (E) temp.value;
    }


    public void display(){
        if(isEmpty()){
            System.out.println(" Stack is Empty");
        }
        Node temp  = head ;
        while (temp!= null){
            System.out.println(temp.value);
             temp = temp.next ;
        }
    }

    public static void main(String[] args) {
        MyStackLinhkedList<Integer> stack = new MyStackLinhkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.display();

        System.out.println("*****************");
        stack.pop();
        stack.pop();
        System.out.println("*****************");
        stack.display();


    }

}
