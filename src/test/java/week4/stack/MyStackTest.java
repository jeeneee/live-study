package week4.stack;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MyStackTest {
    static MyStack stack = new MyStack();

    @BeforeAll
    public static void makeStack() {
        for (int i = 0; i < 11; i++) {
            assertEquals(i, stack.push(i));
        }
    }

    @Test
    @Order(1)
    void push() {
        assertEquals(20, stack.myStack.length);
        assertEquals(11, stack.size);
    }

    @Test
    @Order(2)
    void search() {
        assertEquals(5, stack.search(5));
        assertEquals(-1, stack.search(20));
    }

    @Test
    @Order(3)
    void pop() {
        for (int i = 10; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
        assertThrows(ArrayIndexOutOfBoundsException.class, stack::pop);
    }

    @Test
    @Order(4)
    void empty() {
        assertTrue(stack.empty());
        stack.push(1);
        assertFalse(stack.empty());
    }
}