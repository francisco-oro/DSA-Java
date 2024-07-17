package stack;

import javax.swing.text.html.ObjectView;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Stack {
    private Node top;
    private int length;
    
    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    
    public boolean isEmpty() { 
        return length == 0; 
    }
    
    public int getLength() {
        return length;
    }
    
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        length++;
    }
    
    public int peek() { 
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }
    
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);
        
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}
