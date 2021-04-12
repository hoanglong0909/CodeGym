public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList(5);
        ll.addFirst(13);
        ll.addFirst(12);
        ll.addFirst(11);
        ll.addFirst(10);
//        ll.addFirst(9);
//        ll.addFirst(8);
//        ll.addFirst(7);
//        ll.addFirst(6);
        ll.printList();
        System.out.println("*******************");

        Node currentNode = ll.get(2);
        currentNode.data = 24;
        ll.printList();
        //ll.add(4,852);
//        ll.printList();
    }
}