//singly linked list implementation
public class Singly {
    Node head;

    class Node {

        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    void addFirst(String data) {
        System.out.print("\n adding new node at start\n");
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void addLast(String data) {
        System.out.println("\nadding new node at the last\n");
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;

    }

    void addLoc(int loc, String data) {
        System.out.println("\n adding node after given location " + loc + "\n");
        Node newNode = new Node(data);
        Node currNode = head;
        boolean allocated = false;
        int iterator = 0;
        while (currNode != null) {

            iterator++;
            if (iterator == loc) {
                newNode.next = currNode.next;
                currNode.next = newNode;
                allocated = true;
                break;
            }
            currNode = currNode.next;
        }
        if (!allocated) {
            System.out.println("Index out of range");
        }
    }

    void deleteFirst() {
        System.out.println("\ndeleting the first element\n");
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        head = head.next;
    }

    void deleteLast() {
        System.out.println("\ndeleting element from the last\n");
        if (head == null) {
            System.out.println("list is empty");
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
        currNode.next = null;
    }

    void deleteLoc(int loc) {
        System.out.println("\ndeleting element from given location" + loc + "\n");
        int iterator = 1;
        Node currNode = head;
        while (iterator != loc) {
            currNode = currNode.next;
            iterator++;
        }
        if (currNode.next.next == null) {
            currNode.next = null;
            return;
        }
        currNode.next = currNode.next.next;
    }

    void printList() {
        System.out.println("\n printing list \n");

        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.print("null");
    }

    // program driver main method
    public static void main(String[] args) throws Exception {
        Singly list = new Singly();

        list.addFirst("is");
        list.addFirst("this");
        list.addLast("list");
        list.addLoc(2, "a");
        list.addLoc(3, "linked");
        list.deleteFirst();
        list.deleteLast();
        list.deleteLoc(1);
        list.printList();
    }
}
