package top.parak.Algorithm.Face;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author KHighness
 * @since 2021-03-27
 * @apiNote 给定一个非负数组array和一个整数m，返回array的所有子序列中累加和%m之后的最大值
 */
public class MaxSubsequenceOfModuloM {
    /**
     * 暴力计算所有子序列的总和
     */
    public int max1(int[] array, int m) {
        Set<Integer> set = new HashSet<>();
        process1(array, 0, 0, set);
        int max = 0;
        for (Integer sum : set) {
            max = Math.max(max, sum % m);
        }
        return max;
    }

    public void process1(int[] array, int index, int sum, Set<Integer> set) {
        if (index == array.length) {
            set.add(sum);
        } else {
            // array[index]要或者不要
            process1(array, index + 1, sum, set);                     // 不要array[index]
            process1(array, index + 1, sum + array[index], set); // 要array[index]
        }
    }

    /**
     * 适用于：array中每个数字不大
     * dp[i][j]表示从array[0-i]中选出任意值的和能否得到j
     */
    public int max2(int[] array, int m) {
        int sum = 0;
        int len = array.length;
        for (int i : array) {
            sum += i;
        }
        boolean[][] dp = new boolean[len][sum + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        dp[0][array[0]] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - array[i] >= 0) {
                    dp[i][j] = dp[i][j] | dp[i - 1][j - array[i]];
                }
            }
        }
        int ans = 0;
        for (int j = 0; j <= sum; j++) {
            if (dp[len - 1][j]) {
                ans = Math.max(ans, j % m);
            }
        }
        return ans;
    }

    /**
     * 适用于：array中每个数字很大，m较小
     * dp[i][j]表示从array[0-i]中选出任意值的和%m是否可以达到j
     */
    public int max3(int[] array, int m) {
        int len = array.length;
        boolean[][] dp = new boolean[len][m];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        dp[0][array[0] % m] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j];
                int cur = array[i] % m;
                if (j - cur >= 0) {
                    dp[i][j] = dp[i][j] | dp[i - 1][j - cur];
                } else {
                    dp[i][j] = dp[i][j] | dp[i - 1][m + j - cur];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (dp[len - 1][i]) {
                ans = i;
            }
        }
        return ans;
    }

    /**
     * 分治
     */
    public int max4(int[] array, int m) {
        if (array.length == 1) {
            return array[0] % m;
        }
        int mid = (array.length - 1) / 2;
        TreeSet<Integer> sortSet1 = new TreeSet<>();
        process4(array, 0, 0, mid, m, sortSet1);
        TreeSet<Integer> sortSet2 = new TreeSet<>();
        process4(array, mid + 1, 0, array.length - 1, m, sortSet2);
        int ans = 0;
        for (Integer left : sortSet1) {
            ans = Math.max(ans, left + sortSet2.floor(m - 1 - left));
        }
        return ans;
    }

    public void process4(int[] array, int index, int sum, int end, int m, TreeSet<Integer> sortSet) {
        if (index == end + 1) {
            sortSet.add(sum % m);
        } else {
            process4(array, index + 1, sum, end, m, sortSet);
            process4(array, index + 1, sum + array[index], end, m, sortSet);
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 1, 2 };
        int m = 8;
        System.out.println(new MaxSubsequenceOfModuloM().max1(array, m));
        System.out.println(new MaxSubsequenceOfModuloM().max2(array, m));
        System.out.println(new MaxSubsequenceOfModuloM().max3(array, m));
        System.out.println(new MaxSubsequenceOfModuloM().max4(array, m));
    }

}
