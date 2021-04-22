package com.Long.BubbleSortOptimized;

public class BubbleSortOptimized {

    static void bubbleSort(int[] arr , int n){

        int i , j , temp;
        boolean swapped;

        for (i = 0 ; i< n-1  ; i++){
            swapped = false;

            for (j = 0;  j< n-1 ;j ++) {

                if(arr[j] > arr[j+1]){
                    temp = arr [j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp ;

                    swapped = true ;
                }
            }


            if(swapped == false){
                break;
            }
        }
    }
    static void printAray(int[] arr , int size){
        int i;
        for  (i = 0; i < size ; i++) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,14,5,1,2,4,6};
        int n = arr.length;
        System.out.println("Mảng ban đầu:");
        printAray(arr, n);
        System.out.println("*********************************************");
        bubbleSort(arr, n);
        System.out.println("Mảng sau khi sắp xếp:");
        printAray(arr, n);
    }


}

