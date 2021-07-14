package top.parak.Leetcode;

/**
 * <p> Project: Algorithm </P>
 * <p> Package: top.parak.Leetcode </p>
 * <p> FileName: T13 <p>
 * <p> Description:  <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/27
 * @apiNote 13. 罗马数字转整数
 */

/**
 * Problem:
 * 罗马数字字符串转整数
 */
public class T13 {
    public int romanToInt(String s) {
        if (s.length() == 0) return 0;
        int index = 0, ans = 0;
        while (index != s.length() ) {
            if (s.charAt(index) == 'I' && index + 1 <= s.length() - 1) {
                // IV
                if (s.charAt(index+1) == 'V') {
                    ans += 4;
                    index += 2;
                    continue;
                }
                // IX
                if (s.charAt(index+1) == 'X') {
                    ans += 9;
                    index += 2;
                    continue;
                }
            }
            if (s.charAt(index) == 'X' && index + 1 <= s.length() - 1) {
                // XL
                if (s.charAt(index+1) == 'L') {
                    ans += 40;
                    index += 2;
                    continue;
                }
                // XC
                if (s.charAt(index+1) == 'C') {
                    ans += 90;
                    index += 2;
                    continue;
                }
            }
            if (s.charAt(index) == 'C' && index + 1 <= s.length() - 1) {
                // CD
                if (s.charAt(index+1) == 'D') {
                    ans += 400;
                    index += 2;
                    continue;
                }
                // CM
                if (s.charAt(index+1) == 'M') {
                    ans += 900;
                    index += 2;
                    continue;
                }
            }
            switch (s.charAt(index)) {
                case 'I': ans += 1;break;
                case 'V': ans += 5; break;
                case 'X': ans += 10; break;
                case 'L': ans += 50; break;
                case 'C': ans += 100; break;
                case 'D': ans += 500; break;
                case 'M': ans += 1000; break;
            }
            index++;
        }
        return ans;
    }
}
