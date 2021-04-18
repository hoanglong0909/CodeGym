package com.Long.StackArray.StackArray;

import java.util.Arrays;

public class StackArray<E> {
        private int size = 0;
        private E[] elements ;
//        public static final int DEFAULT_SIZE = 10 ;

    public StackArray(){
        this.elements =  (E[]) new  Object[2];
    }

    public boolean isEmpty(){
        return size == 0 ? true : false ;
    }
    public void push(E e){
        if(elements.length > size){
            ensureCapa();
        }
        elements[size] = e ;
        size++;
    }
    public E pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }
        E temp = elements[size - 1];
        elements[size -1] = null;
        size = size - 1;
        return temp;
    }
    public E peek(){
        if(isEmpty()){
            System.out.println("Stack not peek");
        }
        E temp = elements[size-1];
        return temp;
    }
    public int search(E e){
        if(isEmpty()){
            System.out.println("Stack not search");
        }
        for (int i = 0; i <size ; i++) {
            if(elements[i] == e){
                return i;
            }
        }return -1;
    }
    public void display(){
        System.out.println("this is Array: ");
        for (int i = 0; i <size ; i++) {
            System.out.println(elements[i] + " ");
        }
    }
    public void ensureCapa(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements,newSize) ;
    }

}
