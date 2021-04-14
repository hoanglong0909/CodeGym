import java.util.Arrays;

/**
 * Simple ArrayList Implementation for Java Beginners
 *
 * @author malalanayake
 *
 */
public class ArrayList {
    private Object[] data;
    private int count = 0;
    private int FIXED_SIZE = 10;

    public ArrayList() {
        data = new Object[this.FIXED_SIZE];
    }

    /**
     * Get the specific object
     *
     * @param index
     * @return
     */
    public Object get(int index) {
        if (index < count) {
            return data[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Add new object to the array list
     *
     * @param obj
     */
    public void add(Object obj) {
        if (data.length - count <= data.length / 2) {
            this.reSizeArray();
        }

        data[count++] = obj;
    }

    /**
     * Remove the object from list
     *
     * @param index
     * @return
     */
    public Object remove(int index) {
        if (index < count) {
            Object obj = data[index];
            int temp = index;
            data[index] = null;

            while (temp < count) {
                data[temp] = data[temp + 1];
                data[temp + 1] = null;
                temp++;
            }

            count--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Resizing the array
     */
    public void reSizeArray() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        ArrayList mal = new ArrayList();
        mal.add(2);
        mal.add(5);
        mal.add(1);
        mal.add(23);
        mal.add(14);
        for (int i = 0; i < mal.size(); i++) {
            System.out.print(mal.get(i) + " ");
        }
        mal.add(29);
        System.out.println("Element at position 5:" + mal.get(5));
        System.out.println("Total List size: " + mal.size());
        System.out.println("Removing element at position 2: " + mal.remove(2));
        for (int i = 0; i < mal.size(); i++) {
            System.out.print(mal.get(i) + " ");
        }
    }

}