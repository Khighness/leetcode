package top.parak.Leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author KHighness
 * @since 2020-12-01
 * @apiNote 143. 重排链表
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
        ListNode tempI, tempII, tempIII;
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
