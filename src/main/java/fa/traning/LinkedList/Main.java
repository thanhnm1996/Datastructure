package fa.traning.LinkedList;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(new Student("duc", 13));
        hashSet.add(new Student("duc", 12));
        hashSet.add(new Student("duc", 12));
        hashSet.add(new Student("duc", 12));
        hashSet.forEach(System.out::println);
    }
}
