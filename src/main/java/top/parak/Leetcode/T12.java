package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-01
 * @apiNote 12. 整数转罗马数字
 */
public class T12 {
    public String intToRoman(int num) {
        int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rome = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arab.length; i++) {
            while (num >= arab[i]) {
                num -= arab[i];
                builder.append(rome[i]);
            }
            if (num == 0) break;
        }
        return builder.toString();
    }
}
