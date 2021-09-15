package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-21
 * @apiNote 5. 最长回文子串
 */
public class T5 {

    // dp[i][j]表示s[i-j]是否回文
    public String longestPalindrome(String s) {
        if (s == null) return s;
        int len = s.length();
        if (len <= 1) return s;
        // 状态容器
        boolean[][] dp = new boolean[len][len];
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int start = 0, max = 1; // 初始值很重要
        // 优化
        char[] array = s.toCharArray();
        // 状态转移
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < len - 1 && i < j; i++) {
                if (array[i] != array[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 1) return s;
        char[] arr = s.toCharArray();
        int strlen = arr.length;
        int left = 0, right = 0, len = 1, start = 0, max = 1;
        for (int i = 0; i < strlen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && arr[left] == arr[i]) {
                left--;
                len++;
            }
            while (right < strlen && arr[right] == arr[i]) {
                right++;
                len++;
            }
            while (left >= 0 && right < strlen && arr[left] == arr[right]) {
                left--;
                right++;
                len += 2;
            }
            if (len > max) {
                start = left + 1;
                max = len;
            }
            len = 1;
        }
        return s.substring(start, start + max);
    }

}
