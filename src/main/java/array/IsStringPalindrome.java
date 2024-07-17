package array;

public class IsStringPalindrome 
{
    public static void main(String[] args){
        String s = "aba";
        String se = "abad";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(se));
    }
    
    public static boolean isPalindrome(String word) { 
        char[] chars = word.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
