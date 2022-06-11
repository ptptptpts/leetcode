import java.util.Iterator;
import java.util.LinkedList;

class LRUCache {
    private static final int MAX_KEY = 10000;

    private static class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }

    private int mCapacity;
    private int mNumberOfNodes = 0;

    private final Node mHead = new Node();
    private final Node[] mNodes = new Node[MAX_KEY + 1];

    public LRUCache(int capacity) {
        mCapacity = capacity;
        for (int i = 0; i <= MAX_KEY; i++) {
            mNodes[i] = null;
        }
        mHead.next = mHead;
    }

    public int get(int key) {
        Node node = mNodes[key];

        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = mHead;
            node.next = mHead.next;

            mHead.next.prev = node;
            mHead.next = node;

            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = mNodes[key];

        if (node == null) {
            if (mNumberOfNodes == mCapacity) {
                Node lastNode = mHead.prev;
                mHead.prev = lastNode.prev;
                lastNode.prev.next = mHead;

                mNodes[lastNode.key] = null;
            } else {
                mNumberOfNodes += 1;
            }

            node = new Node();
            mNodes[key] = node;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.prev = mHead;
        node.next = mHead.next;

        mHead.next.prev = node;
        mHead.next = node;

        node.key = key;
        node.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */