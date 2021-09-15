package top.parak.Leetcode;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2020-11-16
 * @apiNote 646. 最长数对链
 */
public class T646 {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair : pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                ans++;
            }
        }
        return ans;
    }

}
