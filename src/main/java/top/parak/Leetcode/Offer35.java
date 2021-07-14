package top.parak.Leetcode;

/**
 * <p> Project: Algorithm </P>
 * <p> Package: top.parak.Leetcode </p>
 * <p> FileName: Offer35 <p>
 * <p> Description:  <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/30
 * @apiNote 剑指 Offer 35. 复杂链表的复制
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 *请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class Offer35 {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * <p>哈希表</p>
     * @param head
     * @return
     */
    public Node solution1(Node head) {
        if (head == null) return null;
        Node curr = head;
        Map<Node, Node> map = new HashMap<>();
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    /**
     * <p>拼接拆分</p>
     * @param head
     * @return
     */
    public Node solution2(Node head) {
        if (head == null) return null;
        Node curr = head;
        // 拼接
        while (curr != null) {
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }
        // random
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // 拆分
        curr = head.next;
        Node prev = head, newHead = head.next;
        while (curr.next != null) {
            prev.next = prev.next.next;
            curr.next = curr.next.next;
            prev = prev.next;
            curr = curr.next;
        }
        // 单独处理原链表尾结点
        prev.next = null;
        return newHead;
    }
}
