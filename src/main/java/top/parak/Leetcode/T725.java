package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/12/1
 * @apiNote 725. 分隔链表
 */

/**
 * Problem:
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 *
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 *
 * 返回一个符合上述规则的链表的列表。
 */
public class T725 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * <p>新建链表</p>
     * @param root
     * @param k
     * @return
     */
    public ListNode[] solution1(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode curr = root;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        int width = length / k, rem = length % k;
        curr = root;
        for (int i = 0; i < k; i++) {
            ListNode head = new ListNode(0), temp = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0); j++) {
                temp.next = new ListNode(curr.val);
                temp = temp.next;
                curr = curr.next;
            }
            ans[i] = head.next;
        }
        return ans;
    }

    /**
     * <p>拆分链表</p>
     * @param root
     * @param k
     * @return
     */
    public ListNode[] solution2(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode curr = root;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        int width = length / k, rem = length % k;
        curr = root;
        for (int i = 0; i < k; i++) {
            ListNode head = curr;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; j++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }
            if (curr != null) {
                ListNode prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            ans[i] = head;
        }
        return ans;
    }

}
