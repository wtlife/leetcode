package code.daybyday.may;

import entity.DLinkedNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        //使用伪头部与伪尾部节点辅助
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }


    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode(key, value);
            cache.put(key, node);
            addToHead(node);

            ++size;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail);
                --size;
            }
        } else {

            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode last = tail.prev;
        removeNode(last);
        return last;
    }

    /**
     * @param node
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除节点
     *
     * @param node
     */
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 头插法
     *
     * @param node
     */
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
