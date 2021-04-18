package Com.Long.QueueArray;

public class TestQueueArray {
    public static void main(String[] args) {
        QueueArray<Integer> myQueue = new QueueArray<>();
        myQueue.display();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.display();
        System.out.println("**********************");
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();

    }
}