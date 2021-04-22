package com.LongBinarySearchTree;

public class BSTPrint {
    //Khởi tạo Node chứa con bên trái, và bên phải.
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    //Khởi tạo root
    Node root;
    public BSTPrint() {
        root = null;
    }
    //Phương thức trả về có giá trị đã thêm
    public Node insertRec(Node root, int key){
        //Trường hợp Tree rỗng
        if (root==null){
            root=new Node(key);
            return root;
        }
        //Xét 2 trường hợp
        if(key<root.data){
            root.left = insertRec(root.left,key);

        }
        if (key> root.data){
            root.right = insertRec(root.right,key);
        }
        return root;
    }
    //Phương thức chính để chèn key lúc  gọi InsertRec
    public void insert(int key){
        root=insertRec(root, key);
    }
    //Phương thức hiển thị
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }
    void inorder() {
        inorderRec(root);
    }

    public static void main(String[] args) {
        BSTPrint bst = new BSTPrint();
        bst.insert(50);
        bst.insert(60);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        bst.inorder();
        System.out.println("******");
    }
         /* Cây nhị phân sau khi được tạo
			50
		  /	  \
		 30	  70
        / \  / \
      20 40 60 80 */
}