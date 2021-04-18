package Com.Long.QueueLinkedList;

import java.util.LinkedList;

public class QueueLinkedList<E> {
    private int size;
    private LinkedList<E> eLements;

    public QueueLinkedList() {
        eLements = new LinkedList<>();
    }

    public void enqueue(E e){
        eLements.addLast(e);
        size++;
    }

    public E dequeue(){
        if (size < 0){
            return null;
        }
        size--;
        return eLements.removeFirst();
    }

    public void display(){
        for (int i = 0; i < size ; i++) {
            System.out.println(eLements.get(i));
        }
    }
}