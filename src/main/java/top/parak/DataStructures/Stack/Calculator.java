package top.parak.DataStructures.Stack;

/**
 * @author KHighness
 * @date 2020/8/28 20:27
 * @apiNote 计算器
 */

/**
 * 定义栈
 */
class Stack {

    private int maxSize;  // 栈的大小
    private int[] stack;  // 模拟数组
    private int top = -1; // 栈顶

    public Stack(int maxSize) {
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
     * 栈顶
     * @return
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top];
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

    /**
     * 运算符优先级
     * @param oper 运算符
     * @return
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否是运算符
     * @param val 字符
     * @return
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}

public class Calculator {

    public static void main(String[] args) {
        /**
         * @index 扫描索引
         * @ch 每次扫描的符号
         * @numberStack 数字栈
         * @operatStack 符号栈
         */
        int index = 0;
        char ch = ' ';
        Stack numberStack = new Stack(10);
        Stack operatStack = new Stack(10);
        int num1 = 0, num2 = 0, oper = 0, res = 0;
        String keepNum = "";
        String expression = "30+2*6-200";
        // 扫描表达式
        while (true) {
            ch = expression.substring(index, index+1).charAt(0);
            if (operatStack.isOper(ch)) { // 当前符号为运算符
                if (!operatStack.isEmpty()) {
                    if (operatStack.priority(ch) <= operatStack.priority(operatStack.peek())) {
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        oper = operatStack.pop();
                        res = numberStack.cal(num1, num2, oper);
                        numberStack.push(res);
                        operatStack.push(ch);
                    } else {
                        operatStack.push(ch);
                    }
                } else {
                    operatStack.push(ch);
                }
            } else { // 当前符号为数字
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numberStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operatStack.isOper(expression.substring(index+1).charAt(0))) {
                        // 下一个符号不是数字，直接入栈
                        numberStack.push(Integer.parseInt(keepNum));
                        // keepNum复位
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        // 处理两个栈
        while (true) {
            // 如果符号为空，则计算到最后的结果哦，数字栈中只有一个数字【结果】
            if (operatStack.isEmpty()) {
                break;
            }
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            oper = operatStack.pop();
            res = numberStack.cal(num1, num2, oper);
            numberStack.push(res);
        }
        System.out.println(expression + " = " + numberStack.pop());
    }

}
