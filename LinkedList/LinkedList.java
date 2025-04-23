
public class LinkedList {

    Node head;

    public void insert(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node tNode = head;
            while (tNode.next != null) {
                tNode = tNode.next;
            }
            tNode.next = node;
        }
    }

    public void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
    }

    public void insertAt(int index, int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (index == 0) {
            insertAtStart(data);
        } else {
            Node tNode = head;
            for (int i = 0; i < index - 1; i++) {
                tNode = tNode.next;
            }
            node.next = tNode.next;
            tNode.next = node;
        }
    }

    public void deleteAt(int index){
        Node tNode1 = head;
        Node tNode2 = null;
            for (int i = 0; i < index - 1; i++) {
                tNode1 = tNode1.next;
            }
            tNode2 = tNode1.next;
            tNode1.next = tNode2.next;
    }

    public void show() {
        Node node = head;
        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }
}
