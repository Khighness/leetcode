package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/25 20:52
 * @apiNote 1290. 二进制链表转整数
 */

import java.util.List;

/**
 * Problem:
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 */
public class T1290 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int getDecimalValue(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        return Integer.valueOf(stringBuilder.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(1 << 1);
    }

}
