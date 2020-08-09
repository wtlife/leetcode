package code.stack;

import java.lang.reflect.Parameter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 155.MinStack
 * @date 2020/8/5
 */
public class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    public MinStack() {
        this.stack= new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.addLast(x);
        if (minStack.isEmpty()|| x<minStack.peekLast()){
            minStack.addLast(x);
        }
    }

    public void pop() {
        if (stack.peekLast().equals(minStack.peekLast())) {
            minStack.pollLast();
        }
        stack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return minStack.pollLast();
    }
}
