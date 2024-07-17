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

    public void display(Node headNode) {
        Node current = headNode;
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
    
    public void insertLast(int data) {
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
//        position is valid and starting from 1
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
    
    public boolean exists(int searchKey) {
        Node current = head;
        while (current != null) {
            if(current.data == searchKey) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public Node reverse() { 
        Node current = head;
        Node previous = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        head = previous;
        return head;
    }
    
    public Node findFromEnd(int n) { 
        if (head == null) {
            return null;
        }
        
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value: n = " + n);
        }
        
        Node main = head;
        Node ref = head;
        int count = 0;
        while(count < n) {
            if (ref == null) {
                throw new IllegalArgumentException(n + " is greater than the number of elements in list");
            }
            ref = ref.next;
            count++;
        }
        while(ref != null) {
            ref = ref.next;
            main = main.next;
        }
        return main;
    }
    
    public void removeDuplicatesFromSorted() { 
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
    
    public Node insertInSortedList(Node newNode) { 
        Node current = head;
        Node temp = null;
        while(current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }
    
    public void removeKey(int key) { 
        Node current = head;
        Node temp = null;
        while(current != null && current.data != key) {
            temp = current;
            current = current.next;
        }
        if (current == null) {
            return;
        }
        temp.next = current.next;
    }
    
    
    /*Floyd's Cycle detection algorithm*/
    public boolean hasLoop(){ 
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                return true;
            }
        }
        return false;
    }
    
    public Node findStartOfLoop() { 
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }
    
    public Node getStartingNode(Node node) {
        Node temp = head;
        while(node != temp) {
            temp = temp.next;
            node = node.next;
        }
        return temp; // Starting node of the loop
    }
    
    public void removeLoop() { 
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                removeLoop(slowPtr);
                return;
            }
        }
    }
    
    private void removeLoop(Node slowPtr) {
        Node temp = head;
        while (slowPtr.next != temp.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }
    
    public static Node merge(Node a, Node b) { 
        Node dummy = new Node(0);
        Node tail = dummy;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next; 
            }
            tail = tail.next;
        } if (a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }
        return dummy.next;
    }
    
    public void createALoop() { 
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        
        head = first; 
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = third;
    }
    
    
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertLast(1);
        list.insertLast(4);
        list.insertLast(8);
        
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertLast(3);
        list2.insertLast(5);
        list2.insertLast(8);
        list2.insertLast(9);
        list2.insertLast(14);
        list2.insertLast(18);
        
        list.display();
        list2.display();
        
        SinglyLinkedList result = new SinglyLinkedList();
        result.head = merge(list.head, list2.head);
        
        result.display();
    }
}
