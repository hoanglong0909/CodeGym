public class TesLinked {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        LinkedListClass ll = new LinkedListClass(41);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.add(3,9);
        ll.add(4,8);
        ll.printList();
    }
}