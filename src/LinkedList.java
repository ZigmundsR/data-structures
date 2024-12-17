public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static LinkedList insert(LinkedList list, int data) {
        Node newNode = new Node(data);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node current = list.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        return list;

    }

    public static LinkedList deleteByKey(LinkedList list, int key) {
        Node current = list.head, previous = null;
        if (current != null && current.data == key) {
            list.head = current.next;
            System.out.println(key + " key found and deleted");
            return list;
        }
        while (current != null && current.data != key) {
            previous = current;
            current = current.next;
        }
        if (current != null) {
            previous.next = current.next;
            System.out.println(key + " key found and deleted");
            return list;
        }

        System.out.println(key + " key not found");

        return list;
    }

    public static LinkedList deleteByPosition(LinkedList list, int position) {
        Node current = list.head, previous = list.head;
        int count = 1;
        if (current != null && count == position) {
            list.head = current.next;
            System.out.println(position + " position found and deleted");
            return list;
        }
        while (current != null) {
            if (count == position) {
                previous.next = current.next;

                System.out.println(position + " position found and deleted");
                return list;
            } else {
                previous = current;
                current = current.next;
                count++;
            }
        }
        System.out.println(position + " position not found/out of bounds");

        return list;
    }

    public static void printLinkedList(LinkedList linkedList) {
        Node current = linkedList.head;

        System.out.print("LinkedList: " + "\n");

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void searchByPosition(LinkedList linkedList, int position) {
        Node current = linkedList.head;
        int count = 1;

        while (current != null) {
            if (count == position) {
                System.out.println(position + " position found with value " + current.data);
                break;
            }
            count++;
            current = current.next;
        }
        if (current == null) {
            System.out.println(position + " position not found/out of bounds");
        }
    }

    public static void searchByKey(LinkedList linkedList, int key) {
        Node current = linkedList.head;
        int pos = 1;
        while (current != null && current.data != key) {
            pos++;
            current = current.next;
        }
        if (current != null) {
            System.out.println(key + " key found at position: " + pos);
        } else {
            System.out.println(key + " key not found");
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList = insert(linkedList, 1);
        linkedList = insert(linkedList, 2);
        linkedList = insert(linkedList, 3);
        linkedList = insert(linkedList, 4);
        linkedList = insert(linkedList, 5);
        linkedList = insert(linkedList, 6);

        printLinkedList(linkedList);

        deleteByKey(linkedList, 4); // delete not at head
        deleteByKey(linkedList, 1); // delete head
        deleteByKey(linkedList, 17); // not found
        printLinkedList(linkedList);

        linkedList = insert(linkedList, 8);
        linkedList = insert(linkedList, 9);
        printLinkedList(linkedList);

        deleteByPosition(linkedList, 1); // delete head, data:2
        deleteByPosition(linkedList, 3); // delete data: 6
        deleteByPosition(linkedList, 17); // not found/out of bounds
        printLinkedList(linkedList);

        searchByKey(linkedList, 8); // found at 3 position
        searchByKey(linkedList, 2); // not found

        searchByPosition(linkedList, 3); // found value 8
        searchByPosition(linkedList, 7); // out of bounds
    }

}
