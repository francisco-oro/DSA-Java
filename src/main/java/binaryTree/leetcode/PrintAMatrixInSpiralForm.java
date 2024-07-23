package binaryTree.leetcode;

import org.ietf.jgss.Oid;

public class PrintAMatrixInSpiralForm {
    public static void spiralForm(int[][] matrix) {
        int i = 0, r = matrix.length, c = matrix[0].length, k = 0, l = 0;
        while(k < r && l < c) {
            /*Left to right*/
            for(i = l; i < c; i++) {
                System.out.print(matrix[k][i] + " ");
            }
            k++;
            /*Top to bottom*/
            for (i = k; i < r; i++) {
                System.out.print(matrix[i][c - 1] + " ");
            }
            c--; 
            /*Right to left*/
            if (k < r) {
                for(i = c - 1; i >= l; i--) {
                    System.out.print(matrix[ r - 1][i] + " ");
                }
                r--;
            }
            /*Bottom to top*/
            if (l < c) {
                for(i = r - 1; i >= k; i--) {
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix_2 = {{1}, {2}};
        spiralForm(matrix);
        spiralForm(matrix_2);
    }
}
