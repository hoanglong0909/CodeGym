

public class LinkedLisst {
    Node head;
// đầu danh sách

//Nút danh sách liên kết. Lớp bên trong này được tạo tĩnh để
//    main () có thể truy cập nó
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
        // Constructor
    }

//    / * Chức năng này in nội dung của danh sách liên kết bắt đầu từ đầu * /
    public void printList(){
        Node n = head;
        while (n != null) {
            System.out.print(n.data + "***");
            n = n.next;
        }
    }

//  / * để tạo một danh sách liên kết đơn giản với 3 nút * /
    public static void main(String[] args)
    {
//      / * Bắt đầu với danh sách trống.
        LinkedLisst llist = new LinkedLisst();

        llist.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        llist.head.next = second; // Liên kết nút đầu tiên với nút thứ hai

        second.next = third;
// Liên kết nút thứ hai với nút thứ ba

        llist.printList();
    }
}
