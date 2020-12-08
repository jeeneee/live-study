package week4.queue;

import java.util.Arrays;

public class MyQueue {
    int[] myQueue = new int[10];
    int left;
    int right;

    public int push(int data) {
        if (right >= myQueue.length) {
            myQueue = Arrays.copyOf(myQueue, myQueue.length * 2);
        }
        return myQueue[right++] = data;
    }

    public int pop() {
        if (left == right) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return myQueue[left++];
        }
    }
}
