package com.LongBinarySearchTree;

public class BSTDelete {
    //Khởi tạo Node chứa con bên trái, và bên phải.
    class Node {
        int key;
        BSTDelete.Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    //Khởi tạo root
    BSTDelete.Node root;

    public BSTDelete() {
        root = null;
    }

    //Phương thức trả về có giá trị đã thêm
    public BSTDelete.Node insertRec(BSTDelete.Node root, int key){
        //Trường hợp Tree rỗng ta cho key vào Tree
        if (root==null){
            root= new BSTDelete.Node(key);
            return root;
        }
        //Xét 2 trường hợp
        if(key<root.key){
            root.left = insertRec(root.left, key);
        }
        else if (key> root.key){
            root.right = insertRec(root.right, key);
        }
        return root;
    }
    //Phương thức chính để chèn key lúc  gọi InsertRec
    public void insert(int key){
        root=insertRec(root, key);
    }
    //Phương thức hiển thị
    void inorderRec(BSTDelete.Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    void inorder() {
        inorderRec(root);
    }
    Node deleteRec(Node root,int key){
        if (root==null) return root;
        //Trường hợp xóa ở Lá
        if (key< root.key)
            root.left=deleteRec(root.left, key);
        else if (key> root.key){
            root.right=deleteRec(root.right, key);
        }
        else{
            //Trường hợp Node cần xóa chỉ có một nút con
            if (root.left==null) return root.right;
            else if (root.right==null) return root.left;
            //Trường hợp Node cần xóa có hai nút con(Như root chẳng hạn)
            root.key =minValue(root.right);
            root.right = deleteRec(root.right,root.key);

        }
        return root;
    }
    void deleteKey(int key){
        root=deleteRec(root, key);
    }
    //
    public int minValue(Node root){
        int minv = root.key;
        while (root.left!=null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    public static void main(String[] args) {
        BSTDelete bst = new BSTDelete();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        System.out.println("Inorder traversal of the given tree");
        bst.inorder();

        System.out.println("\nDelete 20");
        bst.deleteKey(20);
        System.out.println("Inorder traversal of the modified bst");
        bst.inorder();

        System.out.println("\nDelete 30");
        bst.deleteKey(30);
        System.out.println("Inorder traversal of the modified bst");
        bst.inorder();

        System.out.println("\nDelete 50");
        bst.deleteKey(50);
        System.out.println("Inorder traversal of the modified bst");
        bst.inorder();
    }
}