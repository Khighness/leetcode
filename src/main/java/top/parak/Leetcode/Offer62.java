package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-05-05
 * @apiNote Offer62. 圆圈中最后剩下的数字
 */
public class Offer62 {
    /**
     * n = 1, f(n, m) = 1
     * n > 1, f(n, m) = [f(n - 1, m) + m] % n
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public int lastRemaining2(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    static class Node {
        private int no;
        private Node next;

        public Node(int no) {
            this.no = no;
        }
    }

    static class CircleList {
        /**
         * 头节点
         */
         Node head = null;

        /**
         * 初始化环形链表
         * 节点序号: 0 1 2...n-1
         *
         * @param num 节点数量
         */
        public CircleList(int num) {
            Node prev = null;
            for (int i = 0; i < num; i++) {
                Node curr = new Node(i);
                if (i == 0) {
                    head = curr;
                    curr.next = head;
                    prev = head;
                } else {
                    prev.next = curr;
                    curr.next = head;
                    prev = curr;
                }
            }
        }

        /**
         * 出圈顺序
         *
         * @param m 删除第m个数字
         * @return 圈中最后一个数字
         */
        public int process(int m) {
            // help 指向 head 的前驱
            Node help = head;
            while (help.next != head) {
                help = help.next;
            }
            while (help != head) {
                // 剩下最后一个节点，循环结束
                for (int i = 1; i <= m - 1; i++) {
                    head = head.next;
                    help = help.next;
                }
                // head 所指节点出圈
                // System.out.println("[out] " + head.no);
                head = head.next;
                help.next = head;
            }
            return head.no;
        }
    }
}
