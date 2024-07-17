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
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        
//        Now we will connect them together to form a chain
        list.head.next = second;
        second.next = third;
        fourth.next = fourth;
    }
}
