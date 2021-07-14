package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/1 15:07
 * @apiNote 942. 增减字符串匹配
 */

/**
 * Problem:
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 */

/**
 * Solution:
 * min = 0, max = S.length
 * 遇到I则取值min，然后min++
 * 遇到D则取值max，然后max--
 */
public class T942 {

    public int[] diStringMatch(String S) {
        int len = S.length();
        int min = 0, max = len;
        int[] ans = new int[max + 1];
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == 'I') {
                ans[i] = min++;
            } else {
                ans[i] = max--;
            }
        }
        ans[len] = min;
        return ans;
    }

}
