package list;

public class SinglyLinkedList {
    private Node head;
    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public void display() { 
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public int count() { 
        if (head == null) {
            return 0;
        }
        
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    public void insertAt(int data, int index) { 
        if (index < 0 || index > count()) {
            throw new IndexOutOfBoundsException();
        }
        
        Node newNode = new Node(data);
        if (index == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = head;
            int count = 1;
            while (count < index - 1) {
                previous = previous.next;
                count++;
            }
            Node current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }
    }
    
    public Node deleteFirst() { 
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    
    public Node deleteLast() {
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }
    
    public void deleteAtIndex(int index) {
        if (index == 1) {
            head = head.next;     
        } else {
            Node previous = head;
            int count = 1;
            while (count < index - 1) {
                previous = previous.next;
                count++;
            }
            Node current = previous.next;
            previous.next = current.next;
        }
    }
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        
//        Now we will connect them together to form a chain
        list.head.next = second;
        second.next = third;
        third.next = fourth;
        
        list.display();
        System.out.println(list.count());
        list.insertAtBeginning(5);
        list.insertAtEnd(0);
        list.display(); 
        list.insertAt(2, 5);
        list.display();
        
        list.deleteFirst();
        list.deleteLast();
        list.display();
    }
}
