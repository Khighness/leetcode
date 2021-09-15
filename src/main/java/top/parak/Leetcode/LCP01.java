package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-23
 * @apiNote LCP 01. 猜数字
 */
public class LCP01 {

    public int game(int[] guess, int[] answer) {
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                ans++;
            }
        }
        return ans;
    }
}
