package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private TreeNode root;
    private class TreeNode {
        private int data; // Generic type
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
    
    public TreeNode insert(TreeNode root, int data) {
        if (root == null) { // Base case
            root = new TreeNode(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
    
    public void createTree() { 
        root = new TreeNode(5);
        insert(root, 3);
        insert(root, 7);
        insert(root, 1);
    }
    
    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
    
    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }
    
    public TreeNode search(TreeNode root, int data) {
        if (root == null || data == root.data) {
            return root;
        }
        
        if (data < root.data) {
            return search(root.left, data);
        }
        return search(root.right, data);
    }
    
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.createTree();
        tree.inorderTraversal(tree.root);
        
        System.out.println();
        System.out.println(tree.search(tree.root, 1).data);
    }
}
