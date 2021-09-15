package top.parak.Algorithm.Face;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-05-22
 * @apiNote 出栈顺序
 */
public class PrintAllStackOrder {

    public static List<List<Character>> solution(char[] arr) {
        List<List<Character>> res = new ArrayList<>();
        List<Character> cur = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        return res;
    }

    private static void dfs(char[] arr, int index, Stack<Character> stack, List<Character> cur, List<List<Character>> res) {
        if (index == arr.length && stack.isEmpty()) {
            return;
        }
        Stack<Character> stack1 = (Stack<Character>) stack.clone();
        Stack<Character> stack2 = (Stack<Character>) stack.clone();
        // 入栈
        if (index < arr.length) {
            stack1.push(arr[index]);
            dfs(arr, index + 1, stack1, cur, res);
        }
        // 出栈
        if (!stack2.isEmpty()) {
            res.add(new ArrayList<>(cur));
            dfs(arr, index, stack2, cur, res);
        }
    }

    public static void main(String[] args) {
        List<List<Character>> res = solution(new char[]{'A', 'B', 'C'});
        System.out.println(res);
    }

}
