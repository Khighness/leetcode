package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/30
 * @apiNote 817. 链表组件
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 */
public class T817 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * <p>哈希</p>
     * @param head
     * @param G
     * @return
     */
    public int numComponents(ListNode head, int[] G) {
        if (head.next == null || G.length == 1) {
            return 1;
        }
        int index = 0, count = 0;
        ListNode temp = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (temp != null) {
            map.put(temp.val, index++);
            temp = temp.next;
        }
        boolean[] list = new boolean[index];
        for (int i = 0; i < G.length; i++) {
            list[map.get(G[i])] = true;
        }
        // 每出现一个新组件，true
        boolean newComponent = false;
        for (int i = 0; i < index; i++) {
            if (newComponent == false && list[i] == true) {
                count++;
                newComponent = true;
            }
            if (newComponent == true && list[i] == false) {
                newComponent = false;
            }
        }
        return count;
    }

    /**
     * <p>官解</p>
     * @return
     */
    public int officialSolution(ListNode head, int[] G) {
        Set<Integer> Gset = new HashSet<>();
        for (int i : G) Gset.add(i);

        ListNode curr = head;
        int ans = 0;

        while (curr != null) {
            if (Gset.contains(curr.val) && (curr.next == null || !Gset.contains(curr.next.val))) {
                ans++;
            }
            curr = curr.next;
        }
        return ans;
    }

}
