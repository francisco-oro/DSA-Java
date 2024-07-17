package array;

public class MinimumValueArray {
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 7, 10, 6, 7};
        printArray(arr);
        int min = findMin(arr);
        System.out.println(min);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static int findMin(int[] arr) {
//        Edge
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
