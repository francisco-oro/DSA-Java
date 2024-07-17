package array;

import java.security.Key;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int arr[] = {3, 2, 0, 4, 7, 10, 0, 6, 7};
        printArray(arr);
        moveZeroes(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void moveZeroes(int[] arr) {
        int j = 0; // Focus on zeroth elements
        for (int i = 0; i < arr.length; i++) { // Focus on non-zero elements
            if(arr[i] != 0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            
            if (arr[j] != 0) {
                j++;
            } 
        }
    }
}
