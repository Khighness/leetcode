package top.parak.Leetcode;

/**
 * @author  KHighness
 * @since 2020-09-22
 * @apiNote 1486. 数组异或操作
 */
public class T1486 {

    public int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) {
            ans ^= (2 * i + start);
        }
        return ans;
    }

}
