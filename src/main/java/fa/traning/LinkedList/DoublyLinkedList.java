package fa.traning.LinkedList;

public class DoublyLinkedList {
    private int size = 0;
    private Node head;
    private Node tail;

    DoublyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        link(head, tail);
    }


    public void link(Node start, Node end) {
        start.next = end;
        end.prev = start;
    }

    public void addFirst(Node input) {
        link(input, head.next);
        link(head, input);
        size++;
    }

    public void addLast(Node input){
        link(tail.prev, input);
        link(input, tail);
        size++;
    }

    public void addMiddle(Node input, int index) {
        Node current = head;
        int i = -1;
        while (i < index) {
            current = current.next;
            i++;
        }
        link(input, current.next);
        link(current, input);
    }

}
