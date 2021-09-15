package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2021-05-26
 * @apiNote 146. LRU 缓存机制
 */
public class T146 {
    static class LRUCache {
        class LinkedNode {
            int key;
            int value;
            LinkedNode prev;
            LinkedNode next;
            public LinkedNode() { }
            public LinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, LinkedNode> cache;
        private int size;
        private int capacity;
        private LinkedNode head;
        private LinkedNode tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.cache = new HashMap<>();
            head = new LinkedNode();
            tail = new LinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            } else {
                LinkedNode node = cache.get(key);
                moveFirst(node);
                return node.value;
            }
        }

        public void put(int key, int value) {
            LinkedNode node = cache.get(key);
            if (node != null) {
                node.value = value;
                moveFirst(node);
            } else {
                LinkedNode newNode = new LinkedNode(key, value);
                cache.put(key, newNode);
                addFirst(newNode);
                size++;
                if (size> capacity) {
                    LinkedNode last = removeLast();
                    cache.remove(last.key);
                    size--;
                }
            }
        }

        // 添加到头部
        private void addFirst(LinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        // 移动到头部
        private void moveFirst(LinkedNode node) {
            remove(node);
            addFirst(node);
        }

        // 移除结点
        private void remove(LinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // 移除尾部
        private LinkedNode removeLast() {
            LinkedNode node = tail.prev;
            remove(node);
            return node;
        }
    }
}
