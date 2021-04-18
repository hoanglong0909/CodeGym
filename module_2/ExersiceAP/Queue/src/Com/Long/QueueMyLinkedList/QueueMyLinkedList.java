package Com.Long.QueueMyLinkedList;
import java.util.LinkedList;
public class QueueMyLinkedList<E> {
    private QueueMyLinkedList<E> queue;

    public QueueMyLinkedList() {
        queue = new LinkedList<>();
    }

    public void enqueue(E element){
        queue.addLast(element);
    }

    public E dequeue(){
        if (queue.isEmpty()){
            return null;
        } else {
            return queue.removeFirst();
        }
    }

    public void display(){
        queue.display();
    }
}
