package week4.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeQueueTest {

    @Test
    void push() {
        ListNodeQueue queue = new ListNodeQueue();
        queue.push(100);
        queue.push(200);
    }

    @Test
    void pop() {
        ListNodeQueue queue = new ListNodeQueue();
        queue.push(10);
        assertEquals(10, queue.pop());
        assertThrows(IndexOutOfBoundsException.class, queue::pop);
    }
}