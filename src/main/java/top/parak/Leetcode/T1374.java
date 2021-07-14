package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/29 22:28
 * @apiNote 1374. 生成每种字符都是奇数个的字符串
 */

/**
 * Problem:
 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次。
 * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 */
public class T1374 {
    public String generateTheString(int n) {
        if (n == 1) return "k";
        if (n == 2) return "ka";
        int left, right;
        boolean isOdd = false;
        if (n % 2 == 0) { // n为偶数，分成两个奇数
            left = 1;
            right = n - 1;
        } else {         // n为奇数，分成1+1+奇数
            isOdd = true;
            left = 1;
            right = n - 2;
        }
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < left; i++) {
            ans.append('k');
        }
        for (int i = 0; i < right; i++) {
            ans.append('a');
        }
        if (isOdd) {
            ans.append('g');
        }
        return ans.toString();
    }
}
