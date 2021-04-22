package com.LongBinarySearchTree;
public class BST {
    //Khởi tạo Node chứa con bên trái, và bên phải.
    class Node{
        int data;
        Node left, right;

        public Node(int item){
            data = item;
            left = right = null;
        }
    }
    Node root;
    public BST(){
        root = null;
    }
    //Phương thức trả về có giá trị đã thêm
    public Node insertRec(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key< root.data){
            root.left = insertRec(root.left,key);
        }
        else if(key> root.data) {
            root.right = insertRec(root.right,key);
        }
        return  root;
    }
    //Phương thức chính để chèn key lúc  gọi InsertRec
    public void insert(int key){
        root = insertRec(root, key);
    }
    //Phương thức hiển thị
    void innorderRec(Node root){
        if(root != null){
            innorderRec(root.left);

            innorderRec(root.right);
            System.out.println(root.data);
        }
    }

    void inorder(){
        System.out.println("root: "+root.data);
        innorderRec(root);
    }
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        bst.inorder();
        System.out.println("******");
    }
}
