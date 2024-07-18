package queue.leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbersWithQueue {
    public static String[] generateBinaryNumbers(int num) {
        String[] binaryNumbers = new String[num];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for (int i = 0; i < num; i++) {
            binaryNumbers[i] = queue.poll();
            String n1 = binaryNumbers[i] + "0";
            String n2 = binaryNumbers[i] + "1";
            queue.offer(n1);
            queue.offer(n2);
        }
        return binaryNumbers;
    }
    public static void main(String[] args) {
        String[] binaries = generateBinaryNumbers(4);
        for (String binaryNumber : binaries) {
            System.out.println(binaryNumber);
        }
    }
}
