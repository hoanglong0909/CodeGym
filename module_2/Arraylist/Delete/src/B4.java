
import java.util.ArrayDeque;
import java.util.Deque;

import java.util.Queue;
import java.util.Scanner;


public class B4 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];


        Deque<Integer> dequeue = new ArrayDeque<Integer>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            (dequeue).add(arr[i]);

        }

        int k = sc.nextInt();
        for (int i = 1; i <= k; i++) {
            int takeNums = dequeue.pollFirst();
            dequeue.addLast(takeNums);
        }
        for (Integer x : dequeue) {
            System.out.print(x + " ");
        }
    }
}
