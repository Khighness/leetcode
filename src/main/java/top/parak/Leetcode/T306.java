package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-25
 * @apiNote 306. 累加数
 */
public class T306 {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, num.length(), 0, 0, 0, 0);
    }

    /**
     * 回溯
     * @param num   原始字符串
     * @param len   字符串长度
     * @param index 当前下标
     * @param sum   前两个数字之和
     * @param pre   前一个数组
     * @param k     当前处理的是第几个数字
     * @return 唉
     */
    private boolean dfs(String num, int len, int index, long sum, long pre, long k) {
        if (index == len) {
            return k > 2;
        }
        for (int i = index; i < len; i++) {
            long cur = getValue(num, index, i);
            // 剪枝：无效数字
            if (cur < 0)
                continue;
            // 剪枝：当前数字不等于前面两数字之和
            if (k >= 2 && cur != sum)
                continue;
            if (dfs(num, len, i + 1, pre + cur, cur, k + 1))
                return true;
        }
        return false;
    }

    private long getValue(String num, int l, int r) {
        if (l < r && num.charAt(l) == '0') {
            return -1;
        }
        long res = 0;
        while (l <= r) {
            res = res * 10 + num.charAt(l++) - '0';
        }
        return res;
    }
}
