package fa.traning.TestLinkedList;

import javax.xml.crypto.Data;

public class Node<T> {
    private T data;

    public Node<T> next;

    public Node<T> prev;

    public Node(T data) {
        this.data = data;
    }
}
