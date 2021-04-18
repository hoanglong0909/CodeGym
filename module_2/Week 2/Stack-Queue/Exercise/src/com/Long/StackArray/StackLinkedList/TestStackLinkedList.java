package com.Long.StackArray.StackLinkedList;

    public class TestStackLinkedList {
            private static void stackOfIStrings() {
                StackLinkedList<String> stack = new StackLinkedList();
                stack.push("Five");
                stack.push("Four");
                stack.push("Three");
                stack.push("Two");
                stack.push("One");
                System.out.println("1 Size of stack after push operations: " + stack.size());
                System.out.printf("2. Pop elements from stack : ");
                while (!stack.isEmpty()) {
                    System.out.printf(" %s", stack.pop());
                }
                System.out.println("\n1.3. Size of stack after pop operations : " + stack.size());
            }
        public static void main(String[] args) {
            System.out.println("\n2. Stack of Strings");
            stackOfIStrings();
        }
        }





