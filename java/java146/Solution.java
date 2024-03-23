package java146;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer, Integer> m;
    int current;
    Deque<Integer> q;
    Map<Integer, Integer> count;
    int capacity;

    public LRUCache(int capacity) {
        m = new HashMap<>();
        current = 0;
        this.capacity = capacity;
        q = new ArrayDeque<>();
        count = new HashMap<>();
    }

    public int get(int key) {
        if (m.containsKey(key)) {
            q.add(key);
            count.put(key, count.get(key) + 1);
            return m.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            m.put(key, value);
            q.add(key);
            count.put(key, count.get(key) + 1);
            return;
        }
        if (current < capacity) {
            current++;
        } else {
            while (true) {
                int out = q.pollFirst();
                if (count.get(out) == 1) {
                    count.remove(out);
                    m.remove(out);
                    break;
                } else {
                    count.put(out, count.get(out) - 1);
                }
            }
        }
        m.put(key, value);
        count.put(key, 1);
        q.add(key);
    }

    public static void main(String[] args) {
        LRUCache l = new LRUCache(10);
        l.put(10, 13);
        l.put(3, 17);
        l.put(6, 11);
        l.put(10, 5);
        l.put(9, 10);
        l.get(13);
        l.put(2, 19);
        l.get(2);
        l.get(3);
        l.put(5, 25);
        l.get(8);
        l.put(9, 22);
        l.put(5, 5);
        l.put(1, 30);
        l.get(11);
        l.put(9, 12);
        l.get(7);
        l.get(5);
        l.get(8);
        l.get(9);
        l.put(4, 30);
        l.put(9, 3);
        l.get(9);
        l.get(10);
        l.get(10);
        l.put(6, 14);
        l.put(3, 1);
        l.get(3);
        l.put(10, 11);
        l.get(8);
        l.put(2, 14);
        l.get(1);
        l.get(5);
        l.get(4);
        l.put(11, 4);
        l.put(12, 24);
        l.put(5, 18);
        l.get(13);
        l.put(7, 23);
        l.get(8);
        l.get(12);
        l.put(3, 27);
        l.put(2, 12);
        l.get(5);
        l.put(2, 9);
        l.put(13, 4);
        l.put(8, 18);
        l.put(1, 7);
        l.get(6);
        l.put(9, 29);
        l.put(8, 21);
        l.get(5);
        l.put(6, 30);
        l.put(1, 12);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */