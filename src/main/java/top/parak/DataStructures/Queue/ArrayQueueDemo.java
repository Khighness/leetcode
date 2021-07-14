package top.parak.DataStructures.Queue;

import java.util.Scanner;

/**
 * @author KHighness
 * @date 2020/8/27 10:45
 * @apiNote 数组实现队列
 */

class ArrayQueue {

    private int maxSize;  // 队列的最大容量
    private int front;    // 队列头部
    private int rear;     // 队列尾部
    private int[] array;  // 存放数据

    /**
     * 构造器
     * @param arrayMaxSize
     */
    public ArrayQueue(int arrayMaxSize) {
        maxSize = arrayMaxSize;
        array = new int[maxSize];
        front = -1;  // 指向队列头部（指向队列头的前一个位置）
        rear = -1;   // 指向队列尾部（直接指向队列尾部的数据）
    }

    /**
     * 判断队列是否满
     * @return boolean
     */
    public boolean isFull() {
        return rear == maxSize - 1;
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
        rear++;
        array[rear] = n;
    }

    /**
     * 数据出队
     * @return int
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return array[front];
    }

    /**
     * 头数据
     * @return int
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return array[front+1];
    }

    /**
     * 遍历队列
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d] = %d \n", i, array[i]);
        }
    }

}

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("♥ 队列菜单 ♥");
            System.out.println("▶ s(show): 显示队列");
            System.out.println("▶ a(add):  添加数据");
            System.out.println("▶ g(get):  取出数据");
            System.out.println("▶ h(head): 头部数据");
            System.out.println("▶ e(exit): 退出程序");
            System.out.print("输入选项：");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.print("输入一个数: ");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出数据：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("头部数据：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
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
