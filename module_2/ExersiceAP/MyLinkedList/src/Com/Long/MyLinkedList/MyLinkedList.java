package Com.Long.MyLinkedList;

    public class MyLinkedList<E> {
        private Node<E> head = null;
        private Node<E> tail = null;
        private int size;


        public void addFirst(E e) {
            Node<E> temp;
            if (this.tail == null) {
                this.tail = this.head = new Node<>(e);
            }
            else{
                temp = this.head;
                this.head = new Node<>(e);
                this.head.next = temp;
                size++;
            }
        }

        public void addLast(E element) {
            Node<E> temp = new Node<>(element);
            if (this.tail == null) {
                this.head = this.tail = temp;
            }
            else {
                this.tail.next = temp;
                this.tail = temp;
            }
            size++;
        }

        public void add(int index, E element) {
            if (index == 0) {
                addFirst(element);
            } else if (index >= size) {
                addLast(element);
            } else {
                Node<E> current = this.head;
                for (int i = 1; i < index; i++){
                    current = current.next;
                }
                Node<E> temp = current.next;
                current.next = new Node<E>(element);
                temp.next = temp;
                size++;
            }
        }

        public E removeFirst() {
            if (size == 0){
                return null;
            } else {
                Node<E> temp = this.head;
                this.head = temp.next;
                size--;
                if (this.head == null) {
                    this.tail = null;
                }
                return (E) temp.element;
            }
        }

        public E removeLast() {
            if (size == 0){
                return null;
            } else if (size == 1) {
                Node<E> temp = head;
                head = tail = null;
                size = 0;
                return (E) temp.element;
            } else {
                Node<E> current = head;
                for (int i = 0; i < size - 2; i++) {
                    current = current.next;
                }
                Node<E> temp = tail;
                tail = current;
                tail.next = null;
                size--;
                return (E) temp.element;
            }
        }

        public E remove(int index) {
            if (index < 0 || index >= size) {
                return null;
            }
            else if (index == 0) {
                return removeFirst();
            }
            else if (index == size - 1){
                return removeLast();
            }
            else {
                Node previous = head;
                for (int i = 1; i < index; i++) {
                    previous = previous.next;
                }
                Node current = previous.next;
                previous.next = current.next;
                size--;
                return (E) current.element;
            }
        }

        public boolean isEmpty(){
            return (this.size == 0);
        }

        public E peek(){
            if(isEmpty()){
                System.out.println("Error");
                return null;
            } else {
                return this.tail.element;
            }
        }

        public int search(E e){
            Node<E> temp = head;
            for (int i = 0; i < size - 1; i++) {
                if((E) temp.element == e){
                    return i;
                }
                temp = temp.next;
            }
            return -1;
        }

        public int size(){
            return this.size;
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.println( temp.element);
                temp = temp.next;
            }
        }
    }

