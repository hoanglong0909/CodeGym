package Com.Long.MyLinkedList;

public class MyQueueLinkedList<E> {
        private MyQueueLinkedList<E> queue;

        public MyQueueLinkedList() {
            queue = new MyQueueLinkedList<>();
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
}
