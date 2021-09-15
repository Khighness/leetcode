package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-23
 * @apiNote 1646. 获取生成数组中的最大值
 */
public class T1646 {

    public int getMaximumGenerated(int n) {
        if (n < 2) return n;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            }
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }

}
