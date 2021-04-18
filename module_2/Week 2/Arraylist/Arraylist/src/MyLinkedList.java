public class MyLinkedList {
    private Node head;
    private  int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    public void add(int index, Object data){
        Node temp = head;
        Node holder;
        int i=0;
        while (index -1 > i && temp.next != null) {
            temp = temp.next;
            i++;
        }
        System.out.println("temp.data =" + temp.data);
        holder = temp.next;
        System.out.println("holder.data =" + holder.data);
        //temp.next = new Node(data);
        //  temp.next.next = holder;
        Node insertNode = new Node(data);
        temp.next=insertNode;
        insertNode.next = holder;
        numNodes++;
    }
    public void addFirst(Object data){
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    public Node get(int index){
        Node temp= head;
        for (int i=0;i<index;i++){
            System.out.print("temp = " + temp.data+"    ");
            temp=temp.next;
            System.out.print("i ="+i +"    ");
            System.out.println("temp.next = " + temp.data);
        }
        return temp;
    }
    public void removeFirst(){
        Node temp = head;
        head = temp.next;
        temp = null;
        numNodes--;
    }
    public void remove(int index){
        Node temp = head;
        Node holder;
        for (int i = 0; i < index-1 && temp != null ; i++) {
            temp = temp.next;
        }
        if (temp.next != null) {
            Node delNote = temp.next;
            holder = delNote.next;
            temp.next = holder;
            delNote = null;
            numNodes--;
        } else System.out.println("Invalid index!");


    }
    public void printList(){
        Node temp = head;
        while (temp!= null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}