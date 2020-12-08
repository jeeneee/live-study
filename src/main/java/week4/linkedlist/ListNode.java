package week4.linkedlist;

public class ListNode {
    private int value;
    private ListNode next;

    public ListNode() {}

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        ListNode node = head;
        if (position < 0) return null;
        for (int i = 0; i < position; i++) {
            if (node.next == null) break;
            node = node.next;
        }
        nodeToAdd.next = node.next;
        node.next = nodeToAdd;
        return nodeToAdd;
    }

    public ListNode remove(ListNode head, int positionToRemove) {
        if (positionToRemove < 0 || positionToRemove >= getSize(head)) {
            return null;
        }
        for (int i = 0; i < positionToRemove; i++) {
            head = head.next;
        }
        ListNode deletedNode = head.next;
        head.next = head.next.next;
        return deletedNode;
    }

    public boolean contains(ListNode head, ListNode nodeToCheck) {
        if (nodeToCheck == null) return false;
        while (head != null) {
            if (head == nodeToCheck)
                return true;
            head = head.next;
        }
        return false;
    }

    public int getSize(ListNode head) {
        int size = 0;
        while (head.next != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public int getValue() {
        return this.value;
    }

    public String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = getSize(head);
        for (int i = 0; i < size; i++) {
            sb.append(head.next.getValue());
            if (i != size - 1) sb.append(", ");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
