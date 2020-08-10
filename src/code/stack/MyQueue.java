package code.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 232.MyQueue
 * @date 2020/8/9
 */
public class MyQueue {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.inStack = new ArrayDeque<>();
        this.outStack= new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        inStack.addLast(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.addLast(inStack.pollLast());
            }
        }
        return outStack.pollLast();
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.addLast(inStack.pollLast());
            }
        }
        return outStack.peekLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
