package top.parak.DataStructures.Stack;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2020-08-28
 * @apiNote 数组实现栈
 */

// 定义栈
class ArrayStack {

    private int maxSize;  // 栈的大小
    private int[] stack;  // 模拟数组
    private int top = -1; // 栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 判满
     * @return
     */
    public boolean isFull() {
        return top == maxSize -1;
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        top--;
        return stack[top+1];
    }

    /**
     * 遍历
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d \n", i, stack[i]);
        }
    }

}

public class ArrayStackDemo {

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        char key = ' ';
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("♥  栈之菜单  ♥");
            System.out.println("▶ s(show): 显示");
            System.out.println("▶ p(push): 入栈");
            System.out.println("▶ o(pop):  出栈");
            System.out.println("▶ e(exit): 退出");
            System.out.print("请输入选项：");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    stack.show();
                    break;
                case 'p':
                    System.out.print("请输入一个数：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case 'o':
                    try {
                        System.out.println("出栈：" + stack.pop());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 'e':
                    System.out.println("退出程序");
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

}
