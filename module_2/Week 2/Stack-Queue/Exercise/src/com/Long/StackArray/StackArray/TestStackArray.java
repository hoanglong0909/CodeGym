package com.Long.StackArray.StackArray;

public class TestStackArray {
    public static void main(String[] args) {
        StackArray<String> stack = new StackArray<>();
        stack.push("Long");
        stack.push("Khải");
        stack.push("Quang");
        stack.push("Nam");
        stack.push("Hưng");
        stack.display();
        System.out.println("********************************************");

        System.out.println("Array is After pop : " + stack.pop());
        stack.display();
        System.out.println("********************************************");

        System.out.println("Array is After peek : " + stack.peek());
        stack.display();


        System.out.println("********************************************");
        System.out.println(stack.search("Long"));
        System.out.println(stack.search("Thằng ất ơ nào đó"));
    }


}
