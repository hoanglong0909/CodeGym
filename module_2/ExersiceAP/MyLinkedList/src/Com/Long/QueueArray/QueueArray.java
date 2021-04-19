package Com.Long.QueueArray;

import java.util.Arrays;

public class QueueArray<E> {
    public int size = 0;
    public E[] queueArr;

    public QueueArray() {
        queueArr = (E[]) new Object[5];
    }

    public void ensureCapa(){
        int newSize = queueArr.length*2;
        queueArr = Arrays.copyOf(queueArr,newSize);
    }

    public void enqueue(E data){
        if(size == queueArr.length){
            ensureCapa();
        }
        queueArr[size] = data;
        size++;
    }

    public E dequeue(){
        if(size <= 0){
            System.out.println("Queue is empty");
            return null;
        }
        E temp = queueArr[0];
        for (int i = 0; i < size - 1; i++) {
            queueArr[i] = queueArr[i+1];
        }
        if (size == 0) {
            queueArr[size] = null;
        }
        size--;
        return temp;
    }

    public int getSize(){
        return this.size;
    }

    public void display(){
        if(size <= 0){
            System.out.println("Queue is empty");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println("\n"+ "Queue element is: " + queueArr[i] + " ");
        }
    }

    public void diplayFront(){
        if(size <= 0){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("\n"+ "Front element is: " + queueArr[0]);
    }

    public void diplayRear(){
        if(size <= 0){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("\n"+ "Rear element is: " + queueArr[size -1]);
    }
}

