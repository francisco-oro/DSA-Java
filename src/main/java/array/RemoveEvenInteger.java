package array;

public class RemoveEvenInteger {
    public static int[] removeEven(int[] nums) {
        int oddCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                oddCount++;
            }
        }
        
        int[] result = new int[oddCount];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                result[idx++] = nums[i];
            }
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 7, 10, 6, 7};
        printArray(arr);
        int arr_2[] = removeEven(arr);
        printArray(arr_2);
    }
}
