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
        
        list.deleteAtIndex(3);
        list.display();
        
        System.out.println(list.exists(3));
        System.out.println(list.exists(2));
        
        list.reverse();
        list.display();
        
        System.out.println(list.findFromEnd(2).data);
        
        list.removeDuplicatesFromSorted();
        list.display();
        
        list.reverse();
        list.insertInSortedList(new Node(3));
        list.display();
        
        list.removeKey(2);
        list.display();
        
        list.findFromEnd(1).next = second;
        System.out.println(list.hasLoop());
        System.out.println(list.findStartOfLoop().data);
    }
}
