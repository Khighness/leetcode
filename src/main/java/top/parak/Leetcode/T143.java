package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/12/1
 * @apiNote 143. 重排链表
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem:
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class T143 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        int index = 0;
        ListNode temp = head;
        Map<Integer, ListNode> map = new HashMap<>();
        while (temp != null) {
            map.put(index++, temp);
            temp = temp.next;
        }
        ListNode tempI, tempII, tempIII, tempIIII;
        for (int i = 0; i <= index / 2 - 1; i++) {
            // 第i个结点
            tempI = map.get(i);
            // 判断i+1结点
            if (i + 1 != index / 2) {
                tempII = map.get(i+1);
            }
            // 到达分界，判断奇偶
            else {
                // 偶数，最后一个结点为空
                if (index % 2 == 0) {
                    tempII = null;
                }
                // 奇数，最后一个结点为中间结点
                else {
                    tempII = map.get(i+1);
                    tempII.next = null;
                }
            }
            tempIII = map.get(index - 1 -i);
            // 将tempIIII插入到tempI和tempII中间
            tempIII.next = tempII;
            tempI.next = tempIII;
        }
    }
}
