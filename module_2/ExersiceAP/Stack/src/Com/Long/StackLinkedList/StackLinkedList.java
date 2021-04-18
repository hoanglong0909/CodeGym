package Com.Long.StackLinkedList;

import java.util.EmptyStackException;
import java.util.LinkedList;

    public class StackLinkedList<E> {
        private LinkedList<E> stack;
        public StackLinkedList(){
            stack = new LinkedList<>();
        }
        public void push(E e){
            stack.addFirst(e);
        }
        public E pop(){
            if(stack.isEmpty()){
                throw new EmptyStackException();
            }
            return stack.removeLast();
        }
        public int size(){
            return stack.size();
        }
        public boolean isEmpty(){
            return stack.size() == 0 ?true: false ;
        }
    }

