package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-29
 * @apiNote 1021. 删除最外层的括号
 */

/**
 * Problem:
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 */
public class T1021 {
    public String removeOuterParentheses(String s) {
        // 将其看做波浪形，括号越深则越高
        int level = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            // 退一层
            if (c == ')') level--;
            if (level >= 1) sb.append(c);
            // 进一层
            if (c == '(') level++;
        }
        return sb.toString();
    }
}
