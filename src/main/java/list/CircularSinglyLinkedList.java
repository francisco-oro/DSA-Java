package list;


public class CircularSinglyLinkedList {
    private Node last;
    private int length;
    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    
    public CircularSinglyLinkedList() {
        last = null; 
        length = 0;
    }
    
    public int getLength( ) { 
        return length;
    }
    
    public boolean isEmpty( ) {
        return length == 0;
    }
    
    public void createCircularLinkedList() { 
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        
        first.next =second; 
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = first;
        
        last = sixth;   
    }
    
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (last == null) last = newNode;
        else newNode.next = last.next;
        
        last.next = newNode;
        length++;
    }
    
    public void insertEnd(int data) {
        Node newNode = new Node(data); 
        if (last == null) {
            last = newNode;
            last.next = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }
    
    public void traverse () { 
        if (last == null) {
            return;
        }
        
        Node first = last.next;
        while (first != last) {
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.println(first.data + " ");
    }
    
    public static void main(String[] args) { 
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.createCircularLinkedList();
        list.traverse();
        
        list.insertFirst(3);
        list.insertEnd(4);
        list.traverse();
    }
}
