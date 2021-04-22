package com.Long.SelectionSort;

public class SelectionSort {
    void sort(int arr[]){

        int n = arr.length;
        for (int i = 0; i < n-1 ; i++) {
            int min = i;
            for (int j = i +1; j <n ; j++) {

                if(arr[j]<arr[min]){
                    min = j ;
                }
                int temp = arr[i];
                    arr[i] = arr[min] ;
                    arr[min] = temp ;
            }
        }
//        for (int i = 0; i  < n-1 ; i++) {
//           int min = i;
//            for (int j = i +1; j < n  ; j++) {
//                if(arr[j] < arr[min]){
//                    min = j ;
//                }
//                // Hoán đổi phần tử nhỏ nhất và phần tử đầu tiên
//            int temp = arr[min];
//                arr[min] = arr[i];
//                arr[i] = temp ;
//
//            }
//        }
    }
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        SelectionSort ob = new SelectionSort();
        int arr[] = { 64, 25, 12, 22, 11 };
        System.out.println("Mảng ban đầu:");
        ob.printArray(arr);


        ob.sort(arr);
        System.out.println("Mảng sau khi sắp xếp:");
        ob.printArray(arr);
    }
}
