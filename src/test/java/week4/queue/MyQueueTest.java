package week4.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    void push() {
        MyQueue queue = new MyQueue();
        queue.push(100);
        queue.push(200);
    }

    @Test
    void pop() {
        MyQueue queue = new MyQueue();
        assertThrows(ArrayIndexOutOfBoundsException.class, queue::pop);
        queue.push(10);
        assertEquals(10, queue.pop());
    }
}