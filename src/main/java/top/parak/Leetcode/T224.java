package top.parak.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-05-29
 * @apiNote 224. 基本计算器
 */
public class T224 {
    /** 优先级 */
    private HashMap<Character, Integer> priorityMap = new HashMap<Character, Integer>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};
    /** 数字栈 */
    private Deque<Integer> numberStack = new ArrayDeque<>();
    /** 符号栈 */
    private Deque<Character> symbolStack = new ArrayDeque<>();

    public int process(String s) {
        String str = s.replace(" ", "").
                replace("\\(-", "\\(0-").replace("\\(+", "\\(0+").
                replace("+-", "+0-").replace("-+", "-0+");
        char[] arr = str.toCharArray();
        int len = arr.length, cur, index;
        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (c == '(') {
                symbolStack.addLast(c);
            } else if (c == ')') {
                while (!symbolStack.isEmpty() && symbolStack.peekLast() != '(') {
                    calculate();
                }
                symbolStack.pollLast();
            } else if (Character.isDigit(c)) {
                cur = 0; index = i;
                while (index < len && Character.isDigit(arr[index])) {
                    cur = 10 * cur + arr[index++] - '0';
                }
                numberStack.addLast(cur);
                i = index - 1;
            } else {
                while (!symbolStack.isEmpty() && symbolStack.peekLast() != '('
                        && priorityMap.get(symbolStack.peek()) >= priorityMap.get(c)) {
                    calculate();
                }
                symbolStack.addLast(c);
            }
        }
        while (!symbolStack.isEmpty()) calculate();
        return numberStack.pop();
    }

    private void calculate() {
        if (numberStack.isEmpty() || numberStack.size() < 2 || symbolStack.isEmpty()) return;
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
