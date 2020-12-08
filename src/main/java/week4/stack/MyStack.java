package week4.stack;

import java.util.Arrays;

public class MyStack {
    int[] myStack = new int[10];
    int size = 0;

    public int push(int data) {
        if (size >= myStack.length) {
            myStack = Arrays.copyOf(myStack, myStack.length * 2);
        }
        myStack[size++] = data;
        return data;
    }

    public int pop() {
        if (empty()) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return myStack[--size];
        }
    }

    public boolean empty() {
        return size == 0;
    }

    public int search(int data) {
        for (int i = size - 1, j = 0; i >= 0; i--, j++) {
            if (myStack[i] == data) {
                return j;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        int[] strStack = new int[size];
        System.arraycopy(myStack,0,strStack,0,size);
        for(int i = size - 1; i >= size / 2; i--){
            int temp = strStack[i];
            strStack[i] = strStack[size-1-i];
            strStack[size-i-1] = temp;
        }
        return Arrays.toString(strStack);
    }
}
