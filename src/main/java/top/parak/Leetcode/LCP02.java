package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-23
 * @apiNote LCP 02. 分式化简
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
