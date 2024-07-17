package array;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 6, 7, 8, 9 };
        printArray(arr);
        int missingNumber = findMissingNumber(arr);
        System.out.println(missingNumber);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int findMissingNumber(int[] nums) {
        int n = nums.length + 1;
        int sum = n * (n + 1) / 2;
        for(int num : nums) {
            sum = sum - num;
        }
        return sum;
    } 
}
