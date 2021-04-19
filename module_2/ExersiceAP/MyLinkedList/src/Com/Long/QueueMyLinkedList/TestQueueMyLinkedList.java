package Com.Long.QueueMyLinkedList;
public class TestQueueMyLinkedList {
    public static void main(String[] args) {

        QueueMyLinkedList<String> myLinkedListQueue = new QueueMyLinkedList<>();
        myLinkedListQueue.enqueue("Nam ");
        myLinkedListQueue.enqueue("Quang ");
        myLinkedListQueue.enqueue("Long ");
        myLinkedListQueue.enqueue("Hụ");
        myLinkedListQueue.enqueue("han");
        myLinkedListQueue.display();
        System.out.println("*************************");

        System.out.println(myLinkedListQueue.dequeue());
        System.out.println(myLinkedListQueue.dequeue());
//        myLinkedListQueue.dequeue();
        System.out.println("*************************");
//        myLinkedListQueue.dequeue();
//        myLinkedListQueue.dequeue();
//        System.out.println(myLinkedListQueue.peek());
//        System.out.println(myLinkedListQueue.dequeue());
        myLinkedListQueue.display();
    }

}
