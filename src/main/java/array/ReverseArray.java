package array;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 7, 10, 6, 7};
        printArray(arr);
        reverseArray(arr, 0, arr.length - 1);
        printArray(arr);
    }

     public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
