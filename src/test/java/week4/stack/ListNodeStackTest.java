package week4.stack;

import org.junit.jupiter.api.Test;
import week4.linkedlist.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeStackTest {

    @Test
    void push() {
        ListNodeStack stack = new ListNodeStack();
        stack.push(100);
        stack.push(200);
    }

    @Test
    void pop() {
        ListNodeStack stack = new ListNodeStack();
        assertThrows(ArrayIndexOutOfBoundsException.class, stack::pop);
        stack.push(10);
        assertEquals(10, stack.pop());
    }
}