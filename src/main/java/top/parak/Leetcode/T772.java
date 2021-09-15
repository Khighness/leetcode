package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-05-29
 * @apiNote 772. 基本计算器 III
 */
public class T772 {
    /** 优先级 */
    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('-', 1);put('+', 1);put('*', 2);
        put('/', 2);put('%', 2);put('^', 3);
    }};
    /** 数字栈 */
    Stack<Integer> numberStack = new Stack<>();
    /** 符号栈 */
    Stack<Character> symbolStack = new Stack<>();

    public int process(String s) {
        s.replace(" ", "");
        s.replace("\\(-", "(0-");
        s.replace("\\(\\+", "(0+");
        char[] arr = s.toCharArray();
        int len = arr.length, cur, index;
        numberStack.push(0);
        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (c == '(') { // (优先级最低
                symbolStack.push(c);
            } else if (c == ')') { // 每遇到)，将()中的内容计算出来
                while (!symbolStack.isEmpty()) {
                    if (symbolStack.peek() != '(') {
                        calculate();
                    } else {
                        symbolStack.pop();
                        break;
                    }
                }
            } else if (Character.isDigit(c)) { // 计算完整数字
                cur = 0;index = i;
                while (index < len && Character.isDigit(arr[index])) {
                    cur = cur * 10 + arr[index++] - '0';
                }
                numberStack.push(cur);
                i = index - 1;
            } else { // 符号：栈顶>=当前，计算
                while (!symbolStack.isEmpty() && symbolStack.peek() != '(') {
                    char t = symbolStack.peek();
                    if (map.get(t) >= map.get(c)) {
                        calculate();
                    } else {
                        break;
                    }
                }
                symbolStack.add(c);
            }
        }
        while (!symbolStack.isEmpty()) calculate();
        return numberStack.pop();
    }

    private void calculate() {
        if (numberStack.isEmpty() || numberStack.size() < 2) return;
        if (symbolStack.isEmpty()) return;
        int ans = 0, num2 = numberStack.pop(), num1 = numberStack.pop();
        char sym = symbolStack.pop();
        switch (sym) {
            case '+': ans = num1 + num2; break;
            case '-': ans = num1 - num2; break;
            case '*': ans = num1 * num2; break;
            case '/': ans = num1 / num2; break;
            case '^': ans = (int) Math.pow(num1, num2); break;
            case '%': ans = num1 % num2; break;
        }
        numberStack.push(ans);
    }

}
