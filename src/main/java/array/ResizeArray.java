package array;

public class ResizeArray {
    
    public void resize(int[] nums, int k) {
        int[] temp = new int[k];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        nums = temp;
    }
}
