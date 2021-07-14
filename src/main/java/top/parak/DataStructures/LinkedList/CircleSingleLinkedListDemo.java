package top.parak.DataStructures.LinkedList;

/**
 * @author KHighness
 * @date 2020/8/28 14:55
 * @apiNote 环形单向链表->约瑟夫问题
 */

/**
 * Question: Josepfu
 * 设编号为1、2、······n的n个人围坐一圈，约定编号为K(1<=K<=n)的人
 * 从1开始报数，数到m个那个人出列，它的下一位又从1开始报数，疏导m的那
 * 个人又出列，依次类推，直到所有的人出列为止，由此产生一个出队编号的序列
 */

/**
 * Boy结点
 */
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

/**
 * 环形单向链表
 */
class CircleSingleLinkedList {
    // 创建first结点，当前没有编号
    private Boy fisrt = new Boy(-1);

    /**
     * 添加结点
     * 构建环形链表
     * @param num
     */
    public void add(int num) {
        // 限定num
        if (num < 1) {
            System.out.println("num不合法");
            return;
        }
        // 辅助变量
        Boy curBoy = null;
        for (int i = 1; i <= num; i++) {
            // 根据编号，创建结点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                fisrt = boy;
                fisrt.setNext(fisrt);  //n一个小孩构成环
                curBoy = fisrt;
            } else {
                curBoy.setNext(boy);
                boy.setNext(fisrt);
                curBoy = boy;
            }
        }
    }

    /**
     * 显示链表
     */
    public void show() {
        // 判空
        if (fisrt == null) {
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = fisrt;
        while (true) {
            System.out.printf("小孩的编号是%d \n", curBoy.getNo());
            if (curBoy.getNext() == fisrt) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 计算小孩的出圈顺序
     * 1、创建辅助指针helpe指向链表末尾
     * 2、让first和helper同时移动【startNo-1】次
     * 3、循环移动，【countNum-1】次，每次移动后first指向的小孩出圈
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param num      表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int num) {
        // 创建辅助指针
        Boy helper = fisrt;
        // helper移动到末尾
        while (true) {
            if (helper.getNext() == fisrt) {
                break;
            }
            helper = helper.getNext();
        }
        for (int i = 1; i <= startNo - 1; i++) {
            fisrt = fisrt.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (helper == fisrt) {
                // 圈中只有一个结点
                break;
            }
            // 报数countNum-1次
            for (int i = 1; i <= countNum -1; i++) {
                fisrt = fisrt.getNext();
                helper = helper.getNext();
            }
            // first所指出圈
            System.out.println("[OUT]：" + fisrt.getNo());
            fisrt = fisrt.getNext();
            helper.setNext(fisrt);
        }
        // 圈中最后一个
        System.out.println("[LAST]：" + fisrt.getNo());
    }
}

public class CircleSingleLinkedListDemo {

    /**
     * 简单求法
     * @param startNo    起始位置
     * @param countNum   报数次数
     * @param num        总共数量
     */
    public static int solution(int startNo, int countNum, int num) {
        int last = 0;
        for (int i = 2; i <= num; i++) {
            last = (last + countNum) % i;
        }
        return last+1;
    }

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        //  circleSingleLinkedList.show();
        circleSingleLinkedList.countBoy(1, 2, 5);
        System.out.println(solution(1, 2, 5));
    }
}
