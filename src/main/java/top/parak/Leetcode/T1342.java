package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-23
 * @apiNote 1342. 将数字变成 0 的操作次数
 */
public class T1342 {

    public int numberOfSteps (int num) {
        int ans = 0;
        while (num != 0) {
            ans++;
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
        }
        return ans;
    }

}
