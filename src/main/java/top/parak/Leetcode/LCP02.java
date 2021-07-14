package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/23 10:43
 * @apiNote LCP 02. 分式化简
 */

/**
 * Problem:
 * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
 */
public class LCP02 {

    public int[] fraction(int[] cont) {
        // 分子， 分母
        int[] ans = {1, 0};
        for (int i = cont.length - 1; i >= 0; i--) {
            // 上一个分式的分子
            int temp = ans[1];
            // 这次的分母取上一次的分子
            ans[1] = ans[0];
            // 新的分子 = cont[i] * 分母+ 分子
            ans[0] = cont[i] * ans[1] + temp;
        }
        return ans;
    }

}
