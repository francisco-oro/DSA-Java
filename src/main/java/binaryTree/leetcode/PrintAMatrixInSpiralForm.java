package binaryTree.leetcode;

public class PrintAMatrixInSpiralForm {
    public static void spiralForm(int[][] matrix) {
        int i = 0, r = matrix.length - 1, c = matrix[0].length - 1, k = 0, l = 0;
        while(k < r && c < l) {
            /*Left to right*/
            for(i = l; i < c; i++) {
                System.out.print(matrix[k][i] + " ");
            }
            
            /*Top to bottom*/
            
            
            /*Right to left*/
            
            /*Bottom to top*/
        }
    }
    
    public static void main(String[] args) {
        
    }
}
