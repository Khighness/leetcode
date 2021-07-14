package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/30 21:41
 * @apiNote 345. 反转字符串中的元音字母
 */

import java.util.Collections;
import java.util.LinkedList;

/**
 * Problem:
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
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
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                stringBuffer.append(s.charAt(index.removeFirst()));
            } else {
                stringBuffer.append(s.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
         || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T345().reverseVowels("khighness"));
    }

}
