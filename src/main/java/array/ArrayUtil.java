package array;

public class ArrayUtil {
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public void arrayDemo(){ 
        int[] arr = {1,2,3,4,5};
        arr[0] = 5;
        arr[1] = 6;
        arr[2] = 7;
        arr[3] = 8;
        arr[4] = 9;
        printArray(arr);
        System.out.println(arr.length);
        System.out.println(arr[arr.length - 1]);
        
        int[] arr_2 = {5, 6, 7};
        printArray(arr_2);
    }
    
    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.arrayDemo();
    }
}
