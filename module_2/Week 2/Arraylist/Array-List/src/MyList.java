import java.util.Arrays;

        public class MyList<E> {
            private int size = 0;
            private static final int DEFAULT_CAPACITY = 10;
            private Object elements[];

            public MyList() {
                elements = new Object[DEFAULT_CAPACITY];
            }

            private void ensureCapa() {
                int newSize = elements.length * 2;
                elements = Arrays.copyOf(elements, newSize);
            }
            public E get(int i) {
                if (i>= size || i <0) {
                    throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
                }
                return (E) elements[i];
            }
            public void add(E e) {
                if (size == elements.length) {
                    ensureCapa();
                }
                elements[size++] = e;
            }

            public void add(int index, E e) {
                for (int i = size; i > index; i--) {
                    if(i != index){
                        elements[i] = elements[i+1];
                    }
                }
                elements[index] = e;
                size++;
            }

            public void remote(int index){
                    Object temp = elements[index];
                    for(int i =index ; i<size ;i++){
                        elements[index] = elements[i];
                        elements[i] = temp ;
                    }
                    size--;
            }

            public MyList(int size) {
                this.size = size;
            }

            public boolean contains(E e){
                for(int i = 0 ; i < size ; i ++){
                    if(this.get(i) == e) {
                        return true;
                    }
                }
                return false;
            }

            public void display(){
                for(int i = 0 ; i < size ; i ++){
                    System.out.print(elements[i] + " ");
                }
            }
        }
