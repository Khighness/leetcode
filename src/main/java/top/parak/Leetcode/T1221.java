package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/25 21:45
 * @apiNote 1221. 分割平衡字符串
 */

/**
 * Problem:
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * 返回可以通过分割得到的平衡字符串的最大数量。
 */
public class T1221 {
    public int balancedStringSplit(String s) {
        // 遇到L，num+1，遇到S，num-1
        // num == 0 时，产生一个平衡串
        int ans = 0, num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') num++;
            else                    num--;
            if (num == 0)           ans++;
        }
        return ans;
    }
}
