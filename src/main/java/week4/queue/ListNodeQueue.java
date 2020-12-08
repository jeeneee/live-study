package week4.queue;

import week4.linkedlist.ListNode;

public class ListNodeQueue {
    ListNode head = new ListNode();
    int size;

    public void push(int data) {
        head.add(head, new ListNode(data), head.getSize(head));
        size++;
    }

    public int pop() {
        ListNode deletedNode = head.remove(head, --size);
        if (deletedNode == null) {
            throw new IndexOutOfBoundsException();
        } else {
            return deletedNode.getValue();
        }
    }
}
