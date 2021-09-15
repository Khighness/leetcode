package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-26
 * @apiNote 面试题 16.07. 最大数值
 */
public class Face1607 {
    /**
     * 根据数学公式比较大小
     * Max(a, b) = (|a - b| + a + b) / 2
     */
    public int maximum(int a, int b) {
        int ans = (int) ((Math.abs((long) a - (long) b) + (long) a + (long) b) / 2);
        return ans;
    }
}
