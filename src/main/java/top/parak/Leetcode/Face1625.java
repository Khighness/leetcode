package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 面试题 16.25. LRU 缓存
 */
public class Face1625 {
    static class Node<K, V> {
        Node prev;
        Node next;
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    static class DoubleList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        /** 构造函数 */
        public DoubleList() {
            head = new Node(null, null);
            tail = new Node(null, null);
            head.prev = null;
            head.next = tail;
            tail.prev = head;
            tail.next = null;
        }

        /** 添加到头部 */
        public void addFirst(Node<K, V> e) {
            head.next.prev = e;
            e.next = head.next;
            e.prev = head;
            head.next = e;
        }

        /** 移到到头部 */
        public void moveFirst(Node<K, V> e) {
            e.prev.next = e.next;
            e.next.prev = e.prev;
            head.next.prev = e;
            e.next = head.next;
            e.prev = head;
            head.next = e;
        }

        /** 移除尾节点 */
        public Node<K, V> removeLast() {
            Node<K, V> pred = tail.prev;
            if (pred != head) {
                pred.prev.next = tail;
                tail.prev = pred.prev;
            }
            return pred;
        }
    }

    static class LRUCache {
        private final Map<Integer, Node<Integer, Integer>> cache;
        private final DoubleList<Integer, Integer> doubleList;
        private final int capacity;

        public LRUCache(int capacity) {
            cache = new HashMap<>();
            doubleList = new DoubleList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node<Integer, Integer> node = cache.get(key);
            if (node != null) {
                doubleList.moveFirst(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            Node<Integer, Integer> node = cache.get(key);
            if (node != null) {
                node.value = value;
                doubleList.moveFirst(node);
            } else {
                Node<Integer, Integer> newNode = new Node<>(key, value);
                if (cache.size() == capacity) {
                    Node<Integer, Integer> oldNode = doubleList.removeLast();
                    cache.remove(oldNode.key);
                }
                cache.put(key, newNode);
                doubleList.addFirst(newNode);
            }
        }
    }
}
