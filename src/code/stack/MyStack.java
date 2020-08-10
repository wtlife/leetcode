package code.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 225.MyStack
 * @date 2020/8/9
 */
public class MyStack {
    private Deque<Integer> inQueue;
    private Deque<Integer> outQueue;
    /** Initialize your data structure here. */
    public MyStack() {
        this.inQueue = new ArrayDeque<>();
        this.outQueue=new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        inQueue.addLast(x);
        while (!outQueue.isEmpty()){
            inQueue.addLast(outQueue.pollFirst());
        }
        Deque<Integer> tmp =inQueue;
        inQueue =outQueue;
        outQueue=tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return outQueue.pollFirst();
    }

    /** Get the top element. */
    public int top() {
        return outQueue.peekFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return outQueue.isEmpty()&&inQueue.isEmpty();
    }
}
