package stack;

public class ArrayStack {
    private int top; 
    private int[] arr;
    
    public ArrayStack(int capacity ) {
        top = -1;
        arr = new int[capacity];
    }
    
    public ArrayStack() {
        this(10);
    }
    
    public boolean isFull() {
        return top == arr.length - 1;
    }
    
    public int size() { 
        return top + 1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public void push(int data) { 
        if(isFull())  {
            throw new RuntimeException("Stack is full");
        } 
        top++;
        arr[top] = data;
    }
    
    public int pop() {
        if(isEmpty()) throw new RuntimeException("Stack is empty");
        int result = arr[top--];
        return result;
    } 
    
    public int peek() {
        if(isEmpty()) throw new RuntimeException("Stack is empty");
        return arr[top];
    }
    
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}