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
        while (k > 1 && heap[k/2] < heap[k]) {
            int temp = heap[k];
            heap[k] = heap[k / 2];
            heap[k / 2] = temp;
            k = k / 2; // Continue shifting up till new value inserted is at corrected position
        }
    }
    
    public void resize(int newCapacity) {
        int[] temp = new int[newCapacity];
        System.arraycopy(heap, 0, temp, 0, n);
        heap = temp;
    }
    
    public void print() {
        for (int i = 1; i <= n; i++) {
            System.out.print(heap[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        MaxPQ maxPQ = new MaxPQ(4);
        maxPQ.insert(5);
        maxPQ.insert(6);
        maxPQ.insert(2);
        maxPQ.insert(4);
        maxPQ.print();
        System.out.println(maxPQ.size());
        maxPQ.insert(6);
        maxPQ.insert(1);
        maxPQ.insert(3);
        System.out.println(maxPQ.size());
        maxPQ.print();
        
    }
}
