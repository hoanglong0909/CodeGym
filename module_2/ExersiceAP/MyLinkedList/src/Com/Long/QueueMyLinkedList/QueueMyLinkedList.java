package Com.Long.QueueMyLinkedList;
    import Com.Long.MyLinkedList.MyLinkedList;
public class QueueMyLinkedList<E> {
    private MyLinkedList<E> queue;

    public QueueMyLinkedList() {
        queue = new MyLinkedList<>();
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
