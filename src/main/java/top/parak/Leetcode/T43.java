package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 43. 字符串相乘
 */
public class T43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        String ans = "0";
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int len1 = arr1.length, len2 = arr2.length;
        for (int i = len2 - 1; i >= 0; i--) {
            StringBuilder curr = new StringBuilder();
            int next = 0, temp = 0;
            // 补0
            for (int j = len2 - 1; j > i; j--) {
                curr.append(0);
            }
            int digit2 = arr2[i] - '0';
            for (int j = len1 - 1; j >= 0; j--) {
                int digit1 = arr1[j] - '0';
                temp = digit1 * digit2 + next;
                curr.append(temp % 10);
                next = temp / 10;
            }
            if (next != 0) curr.append(next % 10);
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int curr = 0, next = 0, temp = 0;
        for (int x = arr1.length - 1, y = arr2.length - 1; x >=0 || y >= 0; x--, y--) {
            temp = (x >= 0 ? arr1[x] - '0' : 0) + (y >= 0 ? arr2[y] - '0' : 0) + next;
            curr = temp % 10; next = temp / 10;
            ans.append(curr);
        }
        if (next != 0) ans.append(next);
        return ans.reverse().toString();
    }
}
