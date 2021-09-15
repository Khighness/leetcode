package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-25
 * @apiNote 1221. 分割平衡字符串
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
