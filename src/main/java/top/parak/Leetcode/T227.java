package top.parak.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2021-09-15
 * @apiNote 227. 基本计算器 II
 */
public class T227 {
    /**
     * 优先级
     */
    private Map<Character, Integer> priorityMap = new HashMap<Character, Integer>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};

    /**
     * 数字栈
     */
    private Deque<Integer> numberStack = new ArrayDeque<>();
    /**
     * 符号栈，优先级单调递增
     */
    private Deque<Character> symbolStack = new ArrayDeque<>();

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        char[] arr = s.toCharArray();
        int len = arr.length;
        int cur = 0, index = 0;
        numberStack.addLast(0);
        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (c == '(') { // 左括号直接入栈
                symbolStack.addLast(c);
            } else if (c == ')') { // 匹配上一个左括号进行计算
                while (!symbolStack.isEmpty() && symbolStack.peekLast() != '(')
                    calculate();
                symbolStack.pollLast();
            } else if (Character.isDigit(c)) { // 计算当前数字并入栈
                cur = 0;
                index = i;
                while (index < len && Character.isDigit(arr[index]))
                    cur = cur * 10 + arr[index++] - '0';
                numberStack.addLast(cur);
                i = index - 1;
            } else { // 栈顶符号 > 当前符号，则计算
                while (!symbolStack.isEmpty() && symbolStack.peekLast() != '('
                        && priorityMap.get(symbolStack.peekLast()) >= priorityMap.get(c)) {
                    calculate();
                }
                symbolStack.addLast(c);
            }
        }
        while (!symbolStack.isEmpty() && symbolStack.peekLast() != '(')
            calculate();
        return numberStack.peekLast();
    }

    private void calculate() {
        if (numberStack.isEmpty() || numberStack.size() < 2 || symbolStack.isEmpty())
            return;
        int ans = 0, num2 = numberStack.pollLast(), num1 = numberStack.pollLast();
        switch (symbolStack.pollLast()) {
            case '+': ans = num1 + num2; break;
            case '-': ans = num1 - num2; break;
            case '*': ans = num1 * num2; break;
            case '/': ans = num1 / num2; break;
            case '%': ans = num1 % num2; break;
            case '^': ans = num1 ^ num2; break;
        }
        numberStack.addLast(ans);
    }
}
