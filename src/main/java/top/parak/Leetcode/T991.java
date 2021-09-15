package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-09-15
 * @apiNote 991. 坏了的计算器
 */
public class T991 {

    public int brokenCalc(int x, int y) {
        int ans = 0;
        for (;y > x; ans++) {
            if (y % 2 == 1) {
                y++;
            } else {
                y /= 2;
            }
        }
        return ans + x - y;
    }

}
