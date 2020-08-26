package code.sword;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc MinStack
 * @date 2020/8/19
 */
class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.addLast(x);
        if (minStack.isEmpty()|| x<= minStack.peekLast()){
            minStack.addLast(x);
        }
    }

    public void pop() {
        if (stack.pollLast().equals(minStack.peekLast())){
            minStack.pollLast();
        }
    }

    public int top() {
        return stack.peekLast();
    }

    public int min() {
        return minStack.pollLast();
    }
}
