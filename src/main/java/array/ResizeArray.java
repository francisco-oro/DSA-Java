package array;

public class ResizeArray {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printArray(arr);
        arr = resize(arr, 10);
        arr[9] = 10;
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static int[] resize(int[] nums, int k) {
        int[] temp = new int[k];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        return temp;
    }
}
