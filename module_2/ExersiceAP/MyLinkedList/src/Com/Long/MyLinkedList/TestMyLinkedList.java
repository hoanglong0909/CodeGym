package Com.Long.MyLinkedList;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> ll = new MyLinkedList<>();
        ll.add(0,"quang");
        ll.add(1,"thien");
        ll.add(2,"nam");
        ll.add(3,"long");
        ll.display();
        System.out.println("**************************************");
        ll.addFirst("huy");
        ll.addLast("binh");
        ll.display();
        System.out.println("**************************************");
        ll.removeFirst();
        ll.removeLast();
        ll.display();
    }
}
