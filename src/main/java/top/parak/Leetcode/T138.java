package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2021-09-15
 * @apiNote 138. 复制带随机指针的链表
 */
public class T138 {

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

    private Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        if (!map.containsKey(head)) {
            Node node = new Node(head.val);
            map.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}
