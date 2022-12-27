//circular linked list implementation
public class Circular {
    Node head;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }
        Node currNode = head;
        while (currNode.next != head) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.next = head;
        head = newNode;
    }

    void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            addFirst(data);
            return;
        }
        Node currNode = head;
        while (currNode.next != head) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.next = head;
    }

    void addLoc(int loc, String data) {
        if (head == null) {
            System.out.print("list is empty " + loc + "index not found");
            return;
        }
        Node newNode = new Node(data);
        int iterator = 1;
        Node currNode = head;

        while (iterator != loc) {
            currNode = currNode.next;
            iterator++;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    void deleteFirst() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node currNode = head;
        while (currNode.next != head) {
            currNode = currNode.next;
        }
        head = head.next;
        currNode.next = head;
    }

    void deleteLast() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node currNode = head;
        if (currNode.next == head) {
            head = null;
            return;
        }
        while (currNode.next.next != head) {
            currNode = currNode.next;
        }

        currNode.next = head;
    }

    void deleteLoc(int loc) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        int iterator = 1;
        Node currNode = head;
        if (currNode.next == head) {
            head = null;
            return;
        }
        while (iterator != loc) {
            currNode = currNode.next;
            iterator++;
        }
        if (currNode.next == head) {
            head = head.next;
            currNode.next = head;
            return;
        }
        currNode.next = currNode.next.next;
    }

    void printList() {
        Node currNode = head;
        if (head == null) {
            System.out.print("list is empty");
            return;
        }
        while (currNode.next != head) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
            if (currNode.next == head)
                System.out.print(currNode.data + "->");
        }
        System.out.println("head ...");
    }

    public static void main(String[] args) throws Exception {
        Circular circular = new Circular();

        circular.addFirst("circular");
        circular.addLoc(1, "is");
        circular.addLast("this");
        circular.addLoc(3, "linked");
        circular.addLoc(4, "list");
        circular.deleteFirst();
        circular.deleteLoc(1);
        circular.deleteLast();
        circular.printList();
    }
}
