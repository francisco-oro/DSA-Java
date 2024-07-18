package queue;


import java.util.NoSuchElementException;

public class Queue {
    private Node front;
    private Node rear;
    private int length;
    
    private class Node{ 
        private int data;
        private Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public int getLength() { 
        return length;
    }
    
    public boolean isEmpty() {
        return length == 0;
    }
    
    public Queue() { 
        this.front = null;
        this.rear = null;
        this.length = 0; 
    }
    
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if(isEmpty()){
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }
    
    public void print() {
        if (isEmpty()) {
            return;
        }
        Node current = front;
        while(current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int result = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        length--;
        return result;
    }
    
    public int first() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }
    
    public int last() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return rear.data;
    }
    
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.print();;
        
        System.out.println(queue.dequeue());
        queue.print();;
        
        System.out.println(queue.first());
        System.out.println(queue.last());
    }  
}
