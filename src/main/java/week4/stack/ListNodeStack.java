package week4.stack;

import week4.linkedlist.ListNode;

public class ListNodeStack {
    static ListNode head = new ListNode();
    int size;

    void push(int data) {
        head.add(head, new ListNode(data), size++);
    }

    int pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return head.remove(head, --size).getValue();
        }
    }
}
