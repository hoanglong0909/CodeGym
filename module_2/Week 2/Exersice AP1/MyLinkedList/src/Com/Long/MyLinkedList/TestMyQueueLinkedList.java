package Com.Long.MyLinkedList;

public class TestMyQueueLinkedList {
    public static void main(String[] args) {

        MyQueueLinkedList<String> myLinkedListQueue = new MyQueueLinkedList<>();
        myLinkedListQueue.enqueue("Nam Tran");
        myLinkedListQueue.enqueue("Quang Shipper");
        myLinkedListQueue.enqueue("Long Dau Bo");
        myLinkedListQueue.enqueue("Bình Hụ");
        myLinkedListQueue.enqueue("Thien Tatoo");
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

