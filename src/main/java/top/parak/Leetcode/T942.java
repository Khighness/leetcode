package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-10-01
 * @apiNote 942. 增减字符串匹配
 */
public class T942 {

    /**
     * Solution:
     * min = 0, max = S.length
     * 遇到I则取值min，然后min++
     * 遇到D则取值max，然后max--
     */
    public int[] diStringMatch(String S) {
        int len = S.length();
        int min = 0, max = len;
        int[] ans = new int[max + 1];
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == 'I') {
                ans[i] = min++;
            } else {
                ans[i] = max--;
            }
        }
        ans[len] = min;
        return ans;
    }

}
