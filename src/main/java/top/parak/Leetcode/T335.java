package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/14
 * @apiNote 335. 路径交叉
 */

/**
 * Problem:
 * 给定一个含有 n 个正数的数组 x。从点 (0,0) 开始，先向北移动 x[0] 米，然后向西移动 x[1] 米，向南移动 x[2] 米，向东移动 x[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 * 编写一个 O(1) 空间复杂度的一趟扫描算法，判断你所经过的路径是否相交。
 */
public class T335 {
    public boolean isSelfCrossing(int[] x) {
        int l = x.length;
        for (int i = 0; i < l; i++) {
            // 第一条边和第四条边相交
            if (i + 3 < l && x[i + 3] >= x[i + 1] && x[i + 0] >= x[i + 2])
                return true;
            // 第一条边和第五条边相交
            if (i + 4 < l && x[i + 3] == x[i + 1] && x[i + 0] + x[i + 4] >= x[i + 2])
                return true;
            // 第一条边和第六条边相交
            if (i + 5 < l && x[i + 3] > x[i + 1] && x[i + 0] < x[i + 2] && x[i + 4] < x[i + 2] && x[i + 1] + x[i + 5] >= x[i + 3] && x[i + 0] + x[i + 4] >= x[2])
                return true;
        }
        return false;
    }
}









