package top.parak.Leetcode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author KHighness
 * @since 2020-09-30
 * @apiNote 345. 反转字符串中的元音字母
 */
public class T345 {

    public String reverseVowels(String s) {
        // 存储元音字母的下标
        LinkedList<Integer> index = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                index.addLast(i);
            }
        }
        // 反转下标
        Collections.reverse(index);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                builder.append(s.charAt(index.removeFirst()));
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
