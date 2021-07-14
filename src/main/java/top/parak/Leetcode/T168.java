package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/25
 * @apiNote 168. Excel表列名称
 */

/**
 * Problem:
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 */
public class T168 {
    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        /* 10进制转26进制 */
        while (n > 0) {
            n--;
            stringBuilder.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }

        return stringBuilder.toString();
    }
}
