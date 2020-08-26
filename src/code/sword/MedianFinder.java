package code.sword;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Desc 41.MedianFinder
 * @date 2020/8/26
 */
public class MedianFinder {
    //大根堆
    Queue<Integer> left;
    //小根堆
    Queue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>((x, y) -> y - x);
        this.right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.size() == right.size()) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
    }

    public double findMedian() {
        return left.size() == right.size() ?
                (left.peek() + right.peek()) / 2.0 :
                right.peek();
    }
}
