package priorityQueue;

import array.ResizeArray;
import binaryTree.leetcode.SearchInRowAndColumnWiseSortedMatrix;

public class MaxPQ {
    private int[] heap;
    private int n; // Size of max heap
    
    public MaxPQ(int capacity) {
        heap = new int[capacity + 1]; // index 0 is kept as empty
        n = 0;
    }
    public boolean isEmpty() { 
        return n == 0;
    }
    public int size() {
        return n;
    }
    
    public void insert(int value) {
        if(n == heap.length - 1) {
            resize(2 * heap.length);
        }
        heap[++n] = value;
        swim(n);
    }
    
    private void swim(int k) {
        while (k > 1 && heap[k/2] < heap[k]){ 
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;
    }
    
    public static void main(String[] args) {
        MaxPQ maxPQ = new MaxPQ(10);
        System.out.println(maxPQ.isEmpty());
        System.out.println(maxPQ.size());
    }
}
