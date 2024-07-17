package array;

public class SecondMaximumValue {
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 7, 10, 6, 7};
        printArray(arr);
        int secondMax = findSecondMax(arr);
        System.out.println(secondMax);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static int findSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE; // -2147483648
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                secondMax = max; 
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) { // Check for duplicate max value 
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
}
