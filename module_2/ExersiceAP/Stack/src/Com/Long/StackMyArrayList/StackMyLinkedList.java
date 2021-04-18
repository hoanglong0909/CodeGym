package Com.Long.StackMyArrayList;

    public class StackMyLinkedList<E> {
        private Node<E> head;
        private Node<E> tail;
        public StackMyLinkedList(){
            this.head = null;
            this.tail = null;
        }
        public boolean isEmpty(){
            return this.head == null ? true : false ;
        }
        public void push(E e){
            Node<E> temp = new Node<E>(e);
            if(isEmpty()){
                this.head = this.tail = temp ;
            }
            this.tail.next = temp;
            this.tail = temp ;
        }
        public E pop() {
            Node<E> temp = head;
            if(isEmpty()){
                System.out.println("Stack is Empty");
            }
            while (temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            return temp.Value;
        }
        public E peek (E e){
            Node<E>  temp = head;
            if(isEmpty()){
                System.out.println("Stack is Empty");
            }while (temp.next.next != null){
                temp = temp.next;
            }
            return temp.Value;
        }
        public void display(){
            if(isEmpty()){
                System.out.println("Stack is Empty");
            }
            Node temp = head;
            while (temp != null){
                System.out.println(temp.Value);
                temp = temp.next;
            }
        }
    }
