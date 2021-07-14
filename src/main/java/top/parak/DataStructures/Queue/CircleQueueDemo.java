package top.parak.DataStructures.Queue;

import java.util.Scanner;

/**
 * @author KHighness
 * @date 2020/8/27 13:12
 * @apiNote 循环队列
 */

class CircleQueue {

    private int maxSize;  // 队列的最大容量（因为有一个预留空间，最大容量为masSize-1）
    private int front;    // 队列头部（指向队列头部的第一个元素）
    private int rear;     // 队列尾部（指向队列尾部的最后一个元素的后一个位置）
    private int[] array;  // 存放数据

    /**
     * 构造器
     * @param arrayMaxSize
     */
    public CircleQueue(int arrayMaxSize) {
        maxSize = arrayMaxSize;
        array = new int[maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 判断队列是否满
     * @return boolean
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否空
     * @return boolean
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 数据入队
     * @param n
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        array[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 数据出队
     * @return int
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int res = array[front];
        front = (front + 1) % maxSize;
        return res;
    }

    /**
     * 头数据
     * @return int
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return array[front];
    }

    /**
     * 有效数据
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 遍历队列
     * 队列中的有效数的个数：(rear + maxSize - front) % maxSize
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("array[%d] = %d \n", i % maxSize, array[i % maxSize]);
        }
    }
}


public class CircleQueueDemo {

    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("♥ 队列菜单 ♥");
            System.out.println("▶ s(show): 显示队列");
            System.out.println("▶ a(add):  添加数据");
            System.out.println("▶ g(get):  取出数据");
            System.out.println("▶ h(head): 头部数据");
            System.out.println("▶ c(size): 队列规模");
            System.out.println("▶ e(exit): 退出程序");
            System.out.print("输入选项：");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleQueue.showQueue();
                    break;
                case 'a':
                    System.out.print("输入一个数: ");
                    int value = scanner.nextInt();
                    circleQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleQueue.getQueue();
                        System.out.printf("取出数据：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleQueue.headQueue();
                        System.out.printf("头部数据：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'c':
                    System.out.printf("队列规模：%d\n", circleQueue.size());
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("▶  程序结束 ");
    }

}
