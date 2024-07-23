package binaryTree.leetcode;

public class IsValidBinarySearchTree {
    private class TreeNode {
        private int data; // Generic type
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) { // base case
            return true;
        }
        if(root.data <= min || root.data >= max) {
            return false;
        }
        boolean left = isValidBST(root.left, min, root.data);
        if(left) {
            return isValidBST(root.right, root.data, max);
        }
        return false;   
    }
}
