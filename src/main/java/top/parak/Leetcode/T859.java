package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/30
 * @apiNote 859. 亲密字符串
 */

/**
 * Problem:
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 */
public class T859 {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() < 1)  {
            return false;
        }
        int len = A.length();
        // 统计A和B的字母数量
        int[] countA = new int[26], countB = new int[26];
        for (int i = 0; i < len; i++) {
            countA[A.charAt(i) - 'a']++;
            countB[B.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (countA[i] != countB[i]) {
                return false;
            }
        }
        // 如果A==B，那么必须存在一个字母出现大于两次
        if (A.equals(B)) {
            for (int i = 0; i < 26; i++) {
                if (countA[i] > 0) {
                    return true;
                }
            }
            return false;
        }
        // 如果A!=B，那么A和B的异位字母数量必须小于2
        else {
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    count++;
                }
                if (count > 2) {
                    return false;
                }
            }
            return true;
        }
    }
}
