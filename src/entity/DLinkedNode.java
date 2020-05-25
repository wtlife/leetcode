package entity;

public class DLinkedNode {
    public int key;
    public int value;
    public DLinkedNode prev;
    public DLinkedNode next;

    public DLinkedNode() {

    }

    public DLinkedNode(int _key, int _value) {
        this.key = _key;
        this.value = _value;
    }
}
