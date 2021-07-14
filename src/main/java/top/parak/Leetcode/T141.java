package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/30
 * @apiNote 141. 环形链表
 */

/**
 * Problem:
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 */
public class T141 {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 是否有环：使用快慢指针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        while (temp1 != temp2) {
            if (temp2 == null || temp2.next == null) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        return true;
    }

    /**
     * 设慢指针为slot，快指针为fast
     * 环的长度：
     * 记录第一次相遇地点，让慢指针再一次走到相遇地点走过的长度即为环的长度
     * 柄的长度：
     * 假设柄的长度为x，环的长度为l，环的入口点为A，
     * slot第一次到达A时，fast走了n圈并达到距A距离为y的F处(新的一圈走了l-y)
     * 于是 => 2x = x + nl + n - y => x = (n + 1)l - y
     * slot再走y，fast走2y，就会在距A距离为y的M处相遇（新的一圈走了y，M点再走l - y到达A）。
     * 此时让fast指向head，slot指向fast，fast的速度和slot一致，
     * fast从head走到A，距离为x，同时slot走了x = (n + 1)l - y，正好到达A点，两者相遇，
     * 所走的距离即为句柄的长度。
     */
    public int[] lengthOfCycle(ListNode head) {
        if (head == null || head.next == null) {
            return new int[]{0, 0};
        }
        ListNode slot = head, fast = head.next;
        // 第一次相遇
        while (slot != fast) {
            if (fast == null || fast.next == null) {
                return new int[]{0, 0};
            }
            slot = slot.next;
            fast = fast.next.next;
        }
        // 定格fast为相遇点
        slot = slot.next;
        // 环长度
        int lengthOfCycle = 1;
        // 第二次相遇
        while (slot != fast) {
            slot = slot.next;
            lengthOfCycle++;
        }
        // 让fast回到起点
        fast = head;
        slot = slot.next;
        // 柄长度
        int lengthOfHit = 0;
        // 第三次相遇
        while (slot != fast) {
            slot = slot.next;
            fast = fast.next;
            lengthOfHit++;
        }
        return new int[]{lengthOfCycle, lengthOfHit};
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node3;
        int[] length = new T141().lengthOfCycle(node1);
        System.out.println(length[0] + " " + length[1]);
    }

}
