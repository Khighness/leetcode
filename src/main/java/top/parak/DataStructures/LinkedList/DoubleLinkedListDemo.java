package top.parak.DataStructures.LinkedList;

/**
 * @author KHighness
 * @date 2020/8/28 10:29
 * @apiNote 双向链表
 */

/**
 * 定义结点
 */
class  HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 prev;  // 指向前一个结点
    public HeroNode2 next;  // 指向下一个结点

    public HeroNode2(int no, String name, String nickname) {
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
 * 定义双向链表
 */
class DoubleLinkedList {

    // 初始化一个头结点
    private HeroNode2 head = new HeroNode2(0, "", "");

    // 头结点的get方法
    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 添加结点
     * 直接添加到末尾
     * @param heroNode
     */
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.prev = temp;
    }

    /**
     * 添加结点
     * 按照编号插入到指定位置
     * @param heroNode
     */
    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            // System.out.println("[Now]: " + Calendar.getInstance().getTime().toLocaleString() + "  [ temp.next.Data = " + temp.next.no + "], [heroNode.Data = " + heroNode.no + " ]");
            if (temp.next.no == heroNode.no) {
                System.out.printf("编号为%d的结点已经存在，不可重复插入", heroNode.no);
                return;
            }
            if (temp.next.no > heroNode.no) {
                break;
            }
            temp = temp.next;
        }
        if (temp.next != null) { // 如果不是插入到末尾
            heroNode.prev = temp;
            heroNode.next = temp.next;
            temp.next = heroNode;
            temp.next.prev = heroNode;
        } else {
            temp.next = heroNode;
            heroNode.prev = temp;
        }
    }

    /**
     * 修改结点信息
     * 根据结点的no编号修改
     * @param newHeroNode
     */
    public void update(HeroNode2 newHeroNode) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (temp != null) {
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号为%d的结点\n", newHeroNode.no);
        }
    }

    /**
     * 删除结点
     * 1、寻找结点
     * 2、自我删除
     * @param no
     */
    public void del(int no) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag  = false;
        while (temp != null) {
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.prev.next = temp.next;
            // 若删除的不是最后一个结点
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        } else {
            System.out.printf("未找到编号为%d的结点", no);
        }
    }

    /**
     * 显示链表
     */
    public void show() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

}

public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        // 创建结点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "公孙胜", "入云龙");
        HeroNode2 hero5 = new HeroNode2(5, "关胜", "大刀");
        HeroNode2 hero6 = new HeroNode2(6, "林冲", "豹子头");
        HeroNode2 hero7 = new HeroNode2(7, "秦明", "霹雳火");
        HeroNode2 hero8 = new HeroNode2(8, "呼延灼", "双鞭");
        HeroNode2 hero9 = new HeroNode2(9, "花荣", "小李广");

        // 创建链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        // 添加结点
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);
//        doubleLinkedList.add(hero5);
//        doubleLinkedList.add(hero6);
//        doubleLinkedList.add(hero7);
//        doubleLinkedList.add(hero8);
//        doubleLinkedList.add(hero9);

        // 显示链表
//        doubleLinkedList.show();

        // 顺序插入结点
//        doubleLinkedList.addByOrder(hero2);
//        doubleLinkedList.addByOrder(hero5);
//        doubleLinkedList.addByOrder(hero3);
//        doubleLinkedList.addByOrder(hero9);
//        doubleLinkedList.addByOrder(hero1);
//        doubleLinkedList.addByOrder(hero8);
//        doubleLinkedList.addByOrder(hero4);
//        doubleLinkedList.addByOrder(hero7);
//        doubleLinkedList.addByOrder(hero6);
//        doubleLinkedList.show();

        // 修改结点
//        HeroNode2 hero13 = new HeroNode2(9, "小花荣", "李广");
//        doubleLinkedList.update(hero13);
//        System.out.println("修改后的链表");
//        doubleLinkedList.show();

        // 删除结点
//        doubleLinkedList.del(4);
//        doubleLinkedList.del(9);
//        System.out.println("删除后的链表");
//        doubleLinkedList.show();

    }

}
