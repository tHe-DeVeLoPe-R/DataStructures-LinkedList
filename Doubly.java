//Doubly linked list operations implementation
public class Doubly {
    Node head;

    class Node {
        String data;
        Node next, prev;

        Node(String data) {
            this.data = data;

        }
    }

    void addFirst(String data) {
        System.out.println("Adding to first node");
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = null;
            head.prev = null;
            return;
        }
        newNode.next = head;
        newNode.prev = null;
        head = newNode;
    }

    void addLast(String data) {
        System.out.println("adding to last node");
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.next = null;
        newNode.prev = currNode;
    }

    void addLoc(int loc, String data) {
        System.out.println("Adding to given location");
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        int iterator = 1;
        Node currNode = head;
        Node newNode = new Node(data);
        while (iterator != loc) {
            currNode = currNode.next;
            iterator++;
        }
        if (currNode.next == null) {
            newNode.prev = currNode;
            newNode.next = null;
            currNode.next = newNode;
            return;
        }
        newNode.prev = currNode;
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    void deleteFirst() {
        System.out.println("deleting first node");
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        head = head.next;
    }

    void deleteLast() {
        System.out.println("deleting last node");
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node currNode = head;
        if (currNode.next == null) {
            head = null;
            return;
        }
        while (currNode.next.next != null) {
            currNode = currNode.next;
        }
        currNode.next.prev = null;
        currNode.next = null;
    }

    void deleteLoc(int loc) {
        System.out.println("Deleting from given location");
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        int iterator = 1;
        Node currNode = head;
        while (iterator != loc) {
            currNode = currNode.next;
            iterator++;
        }
        if (currNode.next == null) {
            head = null;
            return;
        }
        currNode.next.prev = null;
        currNode.next = currNode.next.next;
    }

    void printList() {
        System.out.println("printing the modified list");
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.print("null");

    }

    public static void main(String[] args) {
        Doubly doubly = new Doubly();

        doubly.addFirst("my");
        doubly.addLast("is");
        doubly.addLoc(1, "list");
        doubly.deleteLoc(1);
        doubly.printList();
    }
}
