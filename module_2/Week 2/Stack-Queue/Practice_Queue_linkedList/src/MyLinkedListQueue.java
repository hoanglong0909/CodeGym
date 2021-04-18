public class MyLinkedListQueue {
    public Node head;
    public Node tail;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int key){
        Node temp = new Node(key);
        if(this.head == null){
            this.head = this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }

    public Node dequeue(){
        if(this.head == null){
            return null;
        }
        Node temp = this.head;
        this.head = this.head.next;
        if(this.head == null){
            this.tail = null;
            return null;
        }
        return temp;
    }


    public static void main(String[] args) {
        MyLinkedListQueue q = new MyLinkedListQueue();
        q.enqueue(1);
        q.enqueue(5);
        System.out.println("Head: " + q.head.key);
        System.out.println("giua : " + q.tail.key);
        q.dequeue();
        System.out.println("giua 2: " + q.head.key);
        System.out.println("Tail: " + q.tail.key);

    }
}