package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-17
 * @apiNote 278. 第一个错误的版本
 */
public class T278 {

    boolean isBadVersion(int version) {
        return false;
    }

    // 找到第一个isBadVersion为true的版本
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}
