package fa.traning.TestLinkedList;

public class DoublyLinkedList<T> {

    private Node<T> head;

    private Node<T> tail;

    public DoublyLinkedList(Node head, Node tail) {
        this.head = new Node(-1);
        this.tail = new Node(-1);

        link(head, tail);
    }
    private void link(Node start, Node end){
        start.next = end;
        end.prev = start;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if(head.next == null) { // empty list case
            link(newNode, tail);
        } else {
            link(newNode, head.next);
        }
        link(head, newNode);
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if(tail.prev == null) { // empty list case
            link(head, newNode);
        } else {
            link(tail.prev, newNode);
        }
        link(newNode, tail);
    }

    public void addMid(int position, T data) {
        Node<T> newNode = new Node<>(data);

        Node<T> currNode = head.next;
        int index = 0;
        while(currNode != null && index < position - 1) {
            currNode = currNode.next;
            index++;
        }

        if(currNode == null) { // end of list case
            link(tail.prev, newNode);
            link(newNode, tail);
        } else {
            link(currNode, newNode);
            link(newNode, currNode.next);
        }
    }

//    public void remove(T data) {
//        Node<T> currNode = head.next;
//
//        while(currNode != null && !currNode.data.equals(data)) {
//            currNode = currNode.next;
//        }
//
//        if(currNode != null) {
//            currNode.prev.next = currNode.next;
//            currNode.next.prev = currNode.prev;
//            currNode.next = null;
//            currNode.prev = null;
//        }
//    }
}
