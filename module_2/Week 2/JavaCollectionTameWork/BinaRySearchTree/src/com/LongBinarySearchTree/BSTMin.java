package com.LongBinarySearchTree;

import org.w3c.dom.Node;

public class BSTMin {
    //Khởi tạo Node chứa con bên trái, và bên phải.
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    //Khởi tạo root
    Node root;

    public BSTMin() {
        root = null;
    }
    //Duyệt qua Tree để tìm giá trị Min
    public int minValue(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }
        return (current.key);
    }
    //Phương thức trả về có giá trị đã thêm
    Node insert(Node node, int data) {
        if (node == null) {
            return (new Node(data));
        } else {
            if (data <= node.key) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
            return node;
        }
    }
    //Phương thức hiển thị
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    void inorder() {
        inorderRec(root);
    }

    public static void main(String[] args) {
        BSTMin bst = new BSTMin();
        Node root = null;
        root=bst.insert(root,50);

        bst.insert(root,30);
        bst.insert(root,20);
        bst.insert(root,40);
        bst.insert(root,70);
        bst.insert(root,60);
        bst.insert(root,80);
        bst.inorder();
        System.out.println("******");
        System.out.println("Min is: "+bst.minValue(root));
    }
         /* Cây nhị phân sau khi được tạo
			50
		  /	  \
		 30	  70
        / \  / \
      20 40 60 80 */
}