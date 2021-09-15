package top.parak.Algorithm.Face;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author KHighness
 * @since 2021-03-16
 * @apiNote 长度为N的数组arr，一定可以组成N^2个数值对。
 * 数值对(X, Y)的比较规则，先比较X，再比较Y。
 * 给定一个数组arr和正数k，返回第k小的数值对。
 */
public class FindKthMinPair {

    public class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair var1, Pair var2) {
            return var1.x != var2.x ? var1.x - var2.x : var1.y - var2.y;
        }
    }

    /**
     * 暴力比较
     */
    public int[] kthMinPair1(int[] array, int k) {
        int N = array.length;
        if (k > N * N) {
            return null;
        }
        Pair[] pairs = new Pair[N * N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pairs[index++] = new Pair(array[i], array[j]);
            }
        }
        Arrays.sort(pairs, new PairComparator());
        return new int[] {pairs[k - 1].x, pairs[k - 1].y};
    }

    /**
     * 区域比较
     */
    public int[] kthMinPair2(int[] array, int k) {
        int N = array.length;
        if (k > N * N) {
            return null;
        }
        Arrays.sort(array);
        int firstNum = array[(k- 1) / N]; // 一维数字
        int lessFirstNumSize = 0; // 数出小于firstNum的数的数量
        int firstNumSize = 0;     // 数出等于firstNum的数的数量
        for (int i = 0; i < N && array[i] <= firstNum; i++) {
            if (array[i] < firstNum) {
                lessFirstNumSize++;
            } else {
                firstNumSize++;
            }
        }
        // 除去前面一维中小于firstNum的数字
        int rest = k - (lessFirstNumSize * N);
        return new int[] { firstNum, array[(rest - 1) / firstNumSize]};
    }

    /**
     * O(n)
     */
    public int[] kthMinPair3(int[] array, int k) {
        int N = array.length;
        if (k > N * N) {
            return null;
        }
        // 在无序数组中，找到第K小的数
        int firstNum = 0;
        int firstNumSize = 0;
        int lessFirstNumSize = 0;
        for (int i = 0; i < N && array[i] <= firstNum; i++) {
            if (array[i] < firstNum) {
                lessFirstNumSize++;
            }
            if (array[i] == firstNum) {
                firstNumSize++;
            }
        }
        int rest = k - lessFirstNumSize * N;
        return new int[] { firstNum, array[(rest - 1) / firstNumSize]};
    }

    /**
     * BFPRT
     */
    public int getMinKthByBFPRT(int[] array, int k) {
        return 0;
    }


}
