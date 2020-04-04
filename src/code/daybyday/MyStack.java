package code.daybyday;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> inQueue;
    private Queue<Integer> outQueue;
    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        this.inQueue = new LinkedList();
        this.outQueue = new LinkedList();
    }
    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        inQueue.add(x);
        while (!outQueue.isEmpty()) {
            inQueue.add(outQueue.poll());
        }
        Queue temp = outQueue;
        outQueue = inQueue;
        inQueue = temp;
    }
    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return outQueue.poll();
    }
    /**
     * Get the top element.
     */
    public int top() {
        return outQueue.peek();
    }
    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return inQueue.isEmpty() && outQueue.isEmpty();
    }
}
