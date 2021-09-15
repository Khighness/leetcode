package top.parak.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author KHighness
 * @since 2020-11-30
 * @apiNote 817. 链表组件
 */
public class T817 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 哈希
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
     * 官解
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
