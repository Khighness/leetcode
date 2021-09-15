package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-18
 * @apiNote 171. Excel表列序号
 */
public class T171 {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        char[] arr = columnTitle.toCharArray();
        for (char c : arr)
            ans = ans * 26 + c - 'A' + 1;
        return ans;
    }
}
