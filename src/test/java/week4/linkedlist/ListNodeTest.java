package week4.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {
    ListNode head = new ListNode();

    @BeforeEach
    public void makeList() {
        for (int i = 0; i < 10; i++) {
            head.add(head, new ListNode(i), i);
        }
    }

    @Test
    void add() {
        assertEquals(10, head.getSize(head));
        ListNode nodeToAdd = new ListNode(10);
        assertEquals(nodeToAdd, head.add(head, nodeToAdd, 3));
        assertNull(head.add(head, new ListNode(100), -1));
    }

    @Test
    void remove() {
        assertNull(head.remove(head, -1));
        assertNull(head.remove(head, 10));
        assertEquals(2, head.remove(head, 2).getValue());
        assertEquals(9, head.getSize(head));
    }

    @Test
    void contains() {
        ListNode nodeToCheck = new ListNode(10);
        head.add(head, nodeToCheck, 0);
        head.add(head, new ListNode(20), 1);
        assertTrue(head.contains(head, nodeToCheck));
        assertFalse(head.contains(head, null));
        assertFalse(head.contains(head, new ListNode(20)));
    }
}