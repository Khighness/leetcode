package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 面试题 16.25. LRU 缓存
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
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

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        // 返回  1
        cache.put(3, 3);
        System.out.println(cache.get(2));
        // 返回 -1 (未找到)
        cache.put(4, 4);
        System.out.println(cache.get(1));
        // 返回 -1 (未找到)
        System.out.println(cache.get(3));
        // 返回  3
        System.out.println(cache.get(4));
        // 返回  4
    }
}

/** solution */
class LRUCache {

    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList {
        Node head;
        Node tail;

        /** 构造函数 */
        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.prev = null;
            head.next = tail;
            tail.prev = head;
            tail.next = null;
        }

        /** 添加到头部 */
        public void addFirst(Node e) {
            head.next.prev = e;
            e.next = head.next;
            e.prev = head;
            head.next = e;
        }

        /** 移到到头部 */
        public void moveFirst(Node e) {
            e.prev.next = e.next;
            e.next.prev = e.prev;
            head.next.prev = e;
            e.next = head.next;
            e.prev = head;
            head.next = e;
        }

        /** 移除尾节点 */
        public Node removeLast() {
            Node pred = tail.prev;
            if (pred != head) {
                pred.prev.next = tail;
                tail.prev = pred.prev;
            }
            return pred;
        }
    }

    private Map<Integer, Node> cache;
    private DoubleList doubleList;
    private int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        doubleList = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            doubleList.moveFirst(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            doubleList.moveFirst(node);
        } else {
            Node newNode = new Node(key, value);
            if (cache.size() == capacity) {
                Node oldNode = doubleList.removeLast();
                cache.remove(oldNode.key);
            }
            cache.put(key, newNode);
            doubleList.addFirst(newNode);
        }
    }
}
