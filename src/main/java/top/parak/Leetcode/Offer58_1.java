package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-09-14
 * @apiNote 剑指 Offer 58 - I. 翻转单词顺序
 */
public class Offer58_1 {

    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i].equals("")) continue;
            builder.append(ss[i]).append(' ');
        }
        return builder.toString().trim();
    }

}
