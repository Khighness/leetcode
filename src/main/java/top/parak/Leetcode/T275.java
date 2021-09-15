package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-17
 * @apiNote 275. H 指数 II
 */
public class T275 {

    /**
     * 对于第i篇论文，引用次数为c[i]，那么引用次数>=arr[i]的论文数量为n - i
     * 找到一篇论文的引用次数c[i] >= n - i，那么就至少有n - i篇论文引用次数大于c[i]
     * H指数 = n - i，求最大的H指数，则是求最小的i
     */
    public int hIndex(int[] citations) {
        int i = 0, n = citations.length;
        for (int c : citations) {
            if (c >= n - i) {
                return n - i;
            } else i++;
        }
        return 0;
    }

    /**
     * 二分搜索
     * 在升序序列中，求满足c[i] >= n - i的i的最小i
     * 通过中间元素，将原始数组一分为二
     */
    public int hIndex2(int[] citations) {
        int i = 0, n = citations.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) >> 1;
            if (citations[mid] == n - mid) {
                return n - mid;
            } else if (citations[mid] < n - mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return n - l;
    }

}
