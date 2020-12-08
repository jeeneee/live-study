package week4.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    MyLinkedList list = new MyLinkedList();

    @Test
    void add() {
        list.add(1);
        list.add(2);
        assertEquals(1, list.head.value);
        assertEquals(2, list.tail.value);
        assertEquals(list.head.next, list.tail);
    }

    @Test
    void remove() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertFalse(list.remove(3));
        assertTrue(list.remove(1));
        assertEquals(list.head.next, list.tail);
        assertTrue(list.remove(1));
        assertTrue(list.remove(0));
        assertNull(list.head);
    }

    @Test
    void indexOf() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(7, list.indexOf(7));
        assertEquals(-1, list.indexOf(10));
    }

    @Test
    void getSize() {
        assertEquals(0, list.getSize());
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.getSize());
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void clear() {
        list.add(1);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void testToString() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list.toString());
    }
}