package queue;


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
    
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
    }
}
