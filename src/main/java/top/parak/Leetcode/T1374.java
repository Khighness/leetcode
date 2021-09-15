package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-29
 * @apiNote 1374. 生成每种字符都是奇数个的字符串
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
        StringBuilder ans = new StringBuilder();
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
