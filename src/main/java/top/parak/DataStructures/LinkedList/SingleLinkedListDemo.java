package top.parak.DataStructures.LinkedList;

/**
 * @author KHighness
 * @since 2020-08-27
 * @apiNote 单向链表
 */
import java.util.Stack;

/**
 * 定义结点
 */
class  HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;  // 指向下一个结点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode [" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ']';
    }
}

/**
 * 定义单向链表
 */
class SingleLinkedList {
    // 初始化一个头结点
    private HeroNode head = new HeroNode(0, "", "");

    // 头结点的get方法
    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加结点
     * 直接添加到末尾
     * 1、找到当前链表的最后结点
     * 2、将最后这个结点的next指向新的结点
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // head结点不能移动，定义辅助遍历temp
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
     * 添加结点
     * 根据编号插入到指定位置
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        // head结点不能移动，定义辅助结点temp
        // 需要找的temp是位于添加位置的前一个结点
        // 添加的结点编号是否存在，默认为不存在
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            // 判断链表是否已经到达末尾
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                // 表示位置找到，temp后面插入即可
                break;
            } else if (temp.next.no == heroNode.no) {
                // 需要添加的结点编号已经存在，不可添加
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("待插入结点编号" + heroNode.no + "已存在，不可重复插入");
            return;
        }
        // 插入结点，调整位置
        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    /**
     * 修改结点信息
     * 根据结点的no编号修改
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            // 判断链表是否达到末尾
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                // 找到相应结点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag判断是否找到要修改的结点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号为%d的结点\n", newHeroNode.no);
        }
    }

    /**
     * 删除结点
     * 1、找到需要删除结点的前一个结点temp
     * 2、temp.next = temp.next.next
     * 3、被删除的结点不会有其他引用指向，会被垃圾回收机制回收
     * @param no
     */
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("未找到编号为%d的结点\n", no);
        }
    }

    /**
     * 显示链表
     */
    public void show() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // head结点不能移动，定义辅助遍历temp
        HeroNode temp = head.next;
        while (true) {
            // 判断链表是否到达末尾
            if (temp == null) {
                break;
            }
            // 输出结点信息
            System.out.println(temp.toString());
            // temp后移
            temp = temp.next;
        }
    }
}

public class SingleLinkedListDemo {

    /**
     * 获取单链表的结点个数
     * @param head 链表头结点
     * @return 返回有效结点个数
     */
    public static int getLength(HeroNode head) {
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 查找单链表中的倒数第K个结点
     * 1、遍历找到链表长度N
     * 2、再次遍历到N-K+1个结点
     */
    public static HeroNode getLastKNode(HeroNode head, int K) {
        int N = 0;  // 得到链表长度
        HeroNode temp = head.next;
        while (temp != null) {
            N++;
            temp = temp.next;
        }
        temp = head.next;
        int X = 1;  // X记录temp的索引
        while (X < N - K + 1) {
            temp = temp.next;
            X++;
        }
        return temp;
    }

    /**
     * 单链表的反转：头插法
     * 1、先定义一个结点 reverseHead
     * 2、从头到尾遍历原来的链表，每遍历一个结点，就将其取出，并放在新链表reverseHead的最前端
     */
    public static void reverseSingleLinkedList(HeroNode head) {
        // 如果当前链表为空或者只有一个结点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return ;
        }

        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode temp = head.next;
        HeroNode next = null;
        while (temp != null) {
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 单链表的反转：转向法
     */
    public static void reverseSingleLinkedList2(HeroNode head) {
        // 如果当前链表为空或者只有一个结点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return ;
        }

        HeroNode reverseHead = null;
        HeroNode temp = head.next;
        HeroNode prev = null;
        HeroNode next = null;
        while (temp != null) {
            next = temp.next;
            if (next != null) {
                reverseHead = next;
            }
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        head.next = reverseHead;
    }

    /**
     * 逆序打印单链表
     * 方法：使用栈
     */
    public static void reverseShow(HeroNode head) {
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode temp = head.next;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序单链表
     */
    public static HeroNode mergeTwoLinkedList1(HeroNode head1, HeroNode head2) {
        HeroNode head = new HeroNode(0, "", "");
        HeroNode temp = head;
        HeroNode temp1 = head1.next;
        HeroNode temp2 = head2.next;
        if (temp1 == null) {
            return head2;
        }
        if (temp2 == null) {
            return head1;
        }
        while (temp1 != null || temp2 != null) {
            if (temp1 != null && temp2!= null) { // temp1和temp2均不为空，择小
                if (temp1.no <= temp2.no) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                    temp = temp.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                    temp = temp.next;
                }
            } else { // temp1和temp2其中一个为空，选择非空
                if (temp1 == null) {
                    temp.next = temp2;
                    temp2 = temp2.next;
                    temp = temp.next;
                } else {
                    temp.next = temp1;
                    temp1 = temp1.next;
                    temp = temp.next;
                }
            }
        }
        return head;
    }

    /**
     * 水浒传排行榜
     * @param args
     */
    public static void main(String[] args) {

        // 创建结点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode hero5 = new HeroNode(5, "关胜", "大刀");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
        HeroNode hero7 = new HeroNode(7, "秦明", "霹雳火");
        HeroNode hero8 = new HeroNode(8, "呼延灼", "双鞭");
        HeroNode hero9 = new HeroNode(9, "花荣", "小李广");

        // 创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //  乱序连接结点
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero9);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero8);
        singleLinkedList.add(hero6);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero7);
        singleLinkedList.add(hero5);
        //  遍历链表
        singleLinkedList.show();

        //  顺序连接结点
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero9);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero8);
//        singleLinkedList.addByOrder(hero6);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero7);
//        singleLinkedList.addByOrder(hero5);
        // 遍历链表
//        singleLinkedList.show();

        // 更新结点
//        singleLinkedList.update(new HeroNode(2, "卢梭义", "包子头"));
//        System.out.println("修改后的链表");
//        singleLinkedList.show();

        // 删除结点
//        singleLinkedList.del(4);
//        singleLinkedList.del(5);
//        singleLinkedList.del(6);
//        singleLinkedList.del(10);
//        System.out.println("删除后的链表");
//        singleLinkedList.show();

        // 结点数量
//        System.out.println(getLength(singleLinkedList.getHead()));

        // 倒数第K个结点
//        System.out.println(getLastKNode(singleLinkedList.getHead(), 1));

        // 链表反转
//        reverseSingleLinkedList(singleLinkedList.getHead());
//        System.out.println("反转之后");
//        singleLinkedList.show();

        // 逆序打印
//        System.out.println("逆序打印");
//        reverseShow(singleLinkedList.getHead());

        // 链表合并
//        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
//        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
//        singleLinkedList1.add(hero1);
//        singleLinkedList1.add(hero3);
//        singleLinkedList1.add(hero5);
//        singleLinkedList1.add(hero7);
//        singleLinkedList1.add(hero9);
//        singleLinkedList2.add(hero2);
//        singleLinkedList2.add(hero4);
//        singleLinkedList2.add(hero6);
//        singleLinkedList2.add(hero8);
//        System.out.println("链表1");
//        singleLinkedList1.show();
//        System.out.println("链表2");
//        singleLinkedList2.show();
//        HeroNode head = mergeTwoLinkedList1(singleLinkedList1.getHead(), singleLinkedList2.getHead());
//        HeroNode temp = head.next;
//        System.out.println("合并后");
//        while (temp != null) {
//            System.out.println(temp.toString());
//            temp = temp.next;
//        }
    }

}
