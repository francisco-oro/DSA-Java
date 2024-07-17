package list;


import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    private static class Node {
        private int data;
        private Node next;
        private Node previous;

        public Node(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    
    public boolean isEmpty() { 
        return length == 0;
    }
    
    public int getLength() {
        return length;
    }
    
    public void insertLast(int data) { 
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.previous = tail; 
        tail = newNode;
        length++;
    }

    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public void displayBackward() {
        if(tail == null) {
            return;
        }
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.previous; 
        }
        System.out.println("null");
    }
    
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            tail = newNode;
        } else { 
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }
    
    public Node deleteFirst() { 
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        return temp;
    }
    
    public Node deleteLast() { 
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        Node temp = head;
        if (head == tail) { 
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        return temp;
    }
    
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(15);
        list.insertFirst(0);
        list.displayForward();
        list.displayBackward();
        
        list.deleteFirst();
        list.deleteLast();
        list.displayForward();
    }
}
