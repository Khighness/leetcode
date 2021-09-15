package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-09-14
 * @apiNote 剑指 Offer 67. 把字符串转换成整数
 */
public class Offer67 {

    public int strToInt(String s) {
        char[] arr = s.toCharArray();
        int i = 0, n = arr.length;
        int ans = 0, flag = 1;

        // 跳过空格
        while (i < n) {
            if (arr[i] == ' ') {
                i++;
            } else {
                break;
            }
        }

        // 确定符号
        if (i == n) {
            return 0;
        }
        if (arr[i] == '-') {
            flag = -1;
            i++;
        } else if (arr[i] == '+') {
            i++;
        }

        while (i < n) {
            char c = arr[i];
            if (c > '9' || c < '0') break;
            if (ans > 214748364 || (ans == 214748364 && (c - '0' > 7))) {
                return 2147483647;
            }
            if (ans < -214748364 || (ans == -214748364 && (c - '0' > 8))) {
                return -2147483648;
            }
            ans = ans * 10 + flag * (c - '0');
            i++;
        }
        return ans;
    }

}
