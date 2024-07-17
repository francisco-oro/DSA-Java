package stack.leetcode;

import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() ){
                while (!stack.isEmpty() && stack.peek() <= nums[i]){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i] = -1;
            } else { 
                result[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return result;
    }
}
