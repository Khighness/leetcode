package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-11-30
 * @apiNote 707. 设计链表
 */
public class T707 {

    class MyLinkedList {
        // Definition for singly-linked list.
        class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }

        int size;
        ListNode head;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        /** Get the value of the index-th node in the linked list.
         * If the index is invalid, return -1. */
        public int get(int index) {
            if (index > size - 1) {
                return -1;
            }
            ListNode temp = head.next;
            while (index-- != 0) {
                temp = temp.next;
            }
            return temp.val;
        }

        /** Add a node of value val before the first element of the
         * linked list. After the insertion, the new node will be
         * the first node of the linked list. */
        public void addAtHead(int val) {
            size++;
            ListNode node = new ListNode(val);
            node.next = head.next;
            head.next = node;
        }

        /** Append a node of value val to the last element of the
         * linked list. */
        public void addAtTail(int val) {
            size++;
            ListNode temp = head, node = new ListNode(val);
            while (temp.next != null) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }

        /** Add a node of value val before the index-th node in the
         * linked list. If index equals to the length of linked list,
         * the node will be appended to the end of linked list. If
         * index is greater than the length, the node will not be
         * inserted. */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            size++;
            // 待插位置的前一个结点
            ListNode temp = head, node = new ListNode(val);
            while (index-- != 0) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }

        /** Delete the index-th node in the linked list, if the index
         * is valid. */
        public void deleteAtIndex(int index) {
            if (index > size - 1) {
                return;
            }
            size--;
            // 待删结点的前一个结点
            ListNode temp = head;
            while (index-- != 0) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

}
