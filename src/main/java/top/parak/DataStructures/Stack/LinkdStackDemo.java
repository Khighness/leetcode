package top.parak.DataStructures.Stack;

/**
 * @author KHighness
 * @date 2020/8/28 17:18
 * @apiNote 链表实现栈
 */

/**
 * 定义节点
 */
class HeroNode {
    public int no;
    public String data;
    public HeroNode next;

    public HeroNode(int no, String data) {
        this.no = no;
        this.data = data;
    }

    @Override
    public String toString() {
        return "HeroNode [" +
                "no=" + no +
                ", data='" + data + '\'' +
                ']';
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 尾部插入节点
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // head节点不能移动，定义辅助遍历temp
        HeroNode temp = head;
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果没有找到，temp后移
            temp = temp.next;
        }
        temp.next = heroNode;

    }

    /**
     * head后插入节点
     * @param heroNode
     */
    public void addAfterHead(HeroNode heroNode) {
        heroNode.next = head.next;
        head.next = heroNode;
    }

    /**
     * 取出head后的节点
     * @return HeroNode
     */
    public HeroNode del() {
        HeroNode res = head.next;
        head.next = res.next;
        res.next = null;
        return res;
    }

    /**
     * 遍历链表
     */
    public void show() {
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    /**
     * 链表长度
     */
    public int size() {
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}

class LinkedStack {

    private int maxSize;
    private SingleLinkedList singleLinkedList;

    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
        singleLinkedList = new SingleLinkedList();
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty() {
        return singleLinkedList.getHead().next == null;
    }

    /**
     * 判满
     * @return
     */
    public boolean isFull() {
        return singleLinkedList.size() == maxSize;
    }

    /**
     * 入栈
     * @param heroNode
     */
    public void push(HeroNode heroNode) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        singleLinkedList.addAfterHead(heroNode);
    }

    /**
     * 出栈
     * @return
     */
    public HeroNode pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return singleLinkedList.del();
    }

    /**
     * 遍历
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        singleLinkedList.show();
    }

}

public class LinkdStackDemo {

    public static void main(String[] args) {
        // 创建节点
        HeroNode hero1 = new HeroNode(1, "K");
        HeroNode hero2 = new HeroNode(2, "H");
        HeroNode hero3 = new HeroNode(3, "I");
        HeroNode hero4 = new HeroNode(4, "G");
        HeroNode hero5 = new HeroNode(5, "H");

//        // 测试链表
//        // 创建链表
//        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        // 插入节点
//        singleLinkedList.addAfterHead(hero1);
//        singleLinkedList.addAfterHead(hero2);
//        singleLinkedList.addAfterHead(hero3);
//        singleLinkedList.addAfterHead(hero4);
//        singleLinkedList.addAfterHead(hero5);
//        // 遍历链表
//        singleLinkedList.show();
//        // 删除节点
//        System.out.println("删除节点" + singleLinkedList.del());
//        System.out.println("删除节点" + singleLinkedList.del());
//        // 链表长度
//        System.out.println("链表长度：" + singleLinkedList.size());

        // 测试栈
        LinkedStack linkedStack = new LinkedStack(10);
        linkedStack.push(hero1);
        linkedStack.push(hero2);
        linkedStack.push(hero3);
        linkedStack.push(hero4);
        linkedStack.push(hero5);
        System.out.println("出栈：" + linkedStack.pop());
        System.out.println("出栈：" + linkedStack.pop());
        System.out.println("出栈：" + linkedStack.pop());
        System.out.println("遍历");
        linkedStack.show();
    }

}
