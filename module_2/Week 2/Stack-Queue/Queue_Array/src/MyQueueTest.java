public class MyQueueTest {

        public static void main(String[] args) {
            MyQueue myQueue = new MyQueue(5);
            myQueue.display();
            myQueue.enqueue(1);
            myQueue.enqueue(2);
            myQueue.enqueue(3);
            myQueue.enqueue(4);
            myQueue.enqueue(5);
            myQueue.display();
            myQueue.enqueue(6);
            myQueue.dequeue();
            myQueue.dequeue();
            myQueue.display();
            myQueue.diplayFront();
            myQueue.diplayRear();



        }
    }

