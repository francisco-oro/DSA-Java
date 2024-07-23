package binaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private TreeNode root;
    public class TreeNode { 
        private int data;
        private TreeNode left;
        private TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }
    
    public void createBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        
        this.root = root;
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
    }
    
    public void preOrder(TreeNode root)  { 
        if (root == null) return; // base case
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public void preOrderWithLoop(TreeNode root) { 
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.data + " ");
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
    }
    
    public void inOrder(TreeNode root) {
        if(root == null) return; 
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    public void inOrderWithLoop(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else { 
                curr = stack.pop();
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
        }
    }
    
    public void postOrder(TreeNode root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    
    public void postOrderWithLoop(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek().right; 
                if(temp == null) { 
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while(!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    curr = temp;
                }
            }
        }
    }
    
    public void levelOrder(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
    }
    
    public int findMax() {
        return findMax(root);
    }
    
    public int findMax(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > result) result = left;
        if(right > result) result = right;
        
        return result;
    }
    
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        binaryTree.preOrderWithLoop(binaryTree.root);
        System.out.println();
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        binaryTree.inOrderWithLoop(binaryTree.root);
        
        System.out.println(); 
        binaryTree.postOrder(binaryTree.root);
        System.out.println();
        binaryTree.postOrderWithLoop(binaryTree.root);
        
        System.out.println();
        binaryTree.levelOrder(binaryTree.root);
        System.out.println();
        
        System.out.println(binaryTree.findMax());
    }
}