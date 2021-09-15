package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-12-04
 * @apiNote 剑指 Offer 64. 求1+2+…+n
 */
public class Offer64 {

    public int sumNums(int n) {
        if (n == 0) {
            return n;
        }
        return n + sumNums(n - 1);
    }

}
