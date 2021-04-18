public class MyQueue {
        public int front = 0;
        public int rear = 0;
        public int capacity;
        public int[] queueArr;

        public MyQueue(int capacity) {
            this.front = 0;
            this.rear = 0;
            this.capacity = capacity;
            this.queueArr = new int[capacity];
        }

        public void enqueue(int data){
            if (this.rear == capacity){
                System.out.println("Queue is full");
                return;
            } else {
                queueArr[rear] = data;
                rear++;
            }
        }

        public void dequeue(){
            if(this.rear == this.front){
                System.out.println("Queue is empty");
                return;
            } else {
                for (int i = 0; i < this.rear - 1 ; i++) {
                    queueArr[i] = queueArr[i+1];
                }
                if (rear < capacity){
                    queueArr[rear] = 0;
                }
                rear--;
            }
        }

        public void display(){
            if(this.rear == this.front){
                System.out.println("Queue is empty");
                return;
            }
            for (int i = front; i < rear; i++) {
                System.out.println("\n"+ "Queue element is: " + queueArr[i] + " ");
            }
        }

        public void diplayFront(){
            if(this.rear == this.front){
                System.out.println("Queue is empty");
                return;
            }
            System.out.println("\n"+ "Front element is: " + queueArr[front]);
        }

        public void diplayRear(){
            if(this.rear == this.front){
                System.out.println("Queue is empty");
                return;
            }
            System.out.println("\n"+ "Rear element is: " + queueArr[rear]);
        }
    }
