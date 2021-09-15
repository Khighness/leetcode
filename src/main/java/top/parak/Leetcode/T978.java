package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-28
 * @apiNote 978. 最长湍流子数组
 */
public class T978 {

    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len <= 1) return len;
        int max = 1;
        int[][] dp = new int[2][len];
        for (int i = 0; i < len; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
        }
        for (int i = 1; i < len; i++) {
            if (i % 2 != 0) {
                if (arr[i] < arr[i - 1]) {
                    dp[0][i] = dp[0][i - 1] + 1;
                }
                if (arr[i] > arr[i - 1]) {
                    dp[1][i] = dp[1][i - 1] + 1;
                }
            } else {
                if (arr[i] > arr[i - 1]) {
                    dp[0][i] = dp[0][i - 1] + 1;
                }
                if (arr[i] < arr[i - 1]) {
                    dp[1][i] = dp[1][i - 1] + 1;
                }
            }
            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }
        return max;
    }

    public int maxTurbulenceSize2(int[] arr) {
        int len = arr.length;
        if (len <= 1) return len;
        int max = 1;
        int[] dp = new int[2];
        dp[0] = 1; dp[1] = 1;
        for (int i = 1; i < len; i++) {
            if ((i % 2 != 0 && arr[i] < arr[i - 1]) || (i % 2 == 0 && arr[i] > arr[i - 1])) {
                dp[0] = dp[0] + 1;
                dp[1] = 1;
            } else if ((i % 2 != 0 && arr[i] > arr[i - 1]) || (i % 2 == 0 && arr[i] < arr[i - 1])) {
                dp[1] = dp[1] + 1;
                dp[0] = 1;
            } else {
                dp[0] = dp[1] = 1;
            }
            max = Math.max(max, Math.max(dp[0], dp[1]));
        }
        return max;
    }

}
