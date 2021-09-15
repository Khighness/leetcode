package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-11-14
 * @apiNote 335. 路径交叉
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









