package binaryTree.leetcode;


public class SearchInRowAndColumnWiseSortedMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        while (i < matrix.length && j >= 0) {
            if(matrix[i][j] == target) {
                System.out.println("Target found: i=" + i + " j=" + j);
                return true;
            }
            if(matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {26, 29, 37, 48},
                {32, 33, 39, 51}
        };
        
        System.out.println(new SearchInRowAndColumnWiseSortedMatrix().searchMatrix(matrix, 32));
    }
}
