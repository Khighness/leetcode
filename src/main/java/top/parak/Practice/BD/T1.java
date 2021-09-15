package top.parak.Practice.BD;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-08-09
 * @apiNote 括号的成对个数即深度
 */

public class T1 {
    public static void main(String[] args) {
        String s = "((())())";
        int[] res = solution(s);
        System.out.println(Arrays.toString(res));
    }

    private static int[] solution(String str) {
        int n = str.length();
        char[] arr = str.toCharArray();
        int count = 0, depth = 0;
        // 存储左括号
        Stack<Character> stack1 = new Stack<>();
        for (char c : arr) {
            if (c == '(') {
                stack1.push('(');
                depth = Math.max(depth, stack1.size());
            } else {
                if (!stack1.isEmpty() && stack1.peek() == '(') {
                    stack1.pop();
                    count++;
                }
            }
        }
//        // 存储左括号下标
//        Stack<Integer> stack2 = new Stack<>();
//        stack2.push(-1);
//
//        // 初始化入度
//
//        int curr = 0;
//        int[] d = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == '(') {
//                curr++;
//            } else {
//                curr = 0;
//            }
//            d[i] = curr;
//        }
//        // 求深度
//        for (int i = 0; i < arr.length; i++) {
//            char c = arr[i];
//            if (c == '(') { // 左括号入栈
//                stack2.push(i);
//            } else { // 右括号处理
//                if (!stack2.isEmpty() && arr[stack2.peek()] == '(') {
//                    stack2.pop();
//                }
//                if (stack2.isEmpty()) {
//                    stack2.push(i);
//                }
//            }
//        }
        return new int[] {count, depth};
    }
}
