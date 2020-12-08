package week4.linkedlist;

public class MyLinkedList {
    private int size = 0;
    Node head = null;
    Node tail = null;

    public static class Node {
        int value;
        Node prev;
        Node next;

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyLinkedList() {}

    public void add(int value) {
        Node node = new Node(value, null, null);
        if (size == 0) {
            head = node;
        } else {
            Node temp = tail;
            temp.next = node;
            node.prev = temp;
        }
        tail = node;
        size++;
    }

    public boolean remove(int index) {
        Node node;
        if (index == 0) {
            node = head.next;
            if (size == 1) {
                clear();
            } else {
                node.prev = null;
                head = node;
            }
        } else if (index == size - 1) {
            node = tail.prev;
            node.next = null;
            tail = node;
        } else {
            node = nodeAt(index);
            if (node == null) {
                return false;
            }
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }
        size--;
        return true;
    }

    public Node nodeAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return head;
        } else if (index == size - 1) {
            return tail;
        }
        Node node;
        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    public int indexOf(int value) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.value == value) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node node = head;
        for (int i = 0; i < size; i++) {
            sb.append(node.value);
            if (i != size - 1) sb.append(", ");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
