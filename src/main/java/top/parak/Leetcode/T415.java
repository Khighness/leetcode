package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 415. 字符串相加
 */
public class T415 {

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
