package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/1 17:26
 * @apiNote 500. 键盘行
 */

/**
 * Problem:
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
 * 键盘:
 * QWERTYUIOP
 *  ASDFGHJKL
 *   ZXCVBNM
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution:
 * 大小写转换:
 * - toLowerCase()
 * - toUpperCase()
 */
public class T500 {
    public String[] findWords(String[] words) {
        HashSet set = new HashSet<Integer>();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i].toUpperCase();
            set.clear();
            for (int j = 0; j < s.length(); j++) {
                int val = getKeyBoardValue(s.charAt(j));
                set.add(val);
            }
            if (set.size() == 1) list.add(words[i]);
        }
        return list.toArray(new String[list.size()]);
    }

    public int getKeyBoardValue(char c) {
        if (c == 'Q' || c == 'W' || c == 'E' || c == 'R' || c == 'T' || c == 'Y' || c == 'U' || c == 'I' || c == 'O' || c == 'P') {
            return 1;
        } else if (c == 'A' || c == 'S' || c == 'D' || c == 'F' || c == 'G' || c == 'H' || c == 'J' || c== 'K' || c == 'L') {
            return 2;
        } else if (c == 'Z' || c == 'X' || c == 'C' || c == 'V' || c == 'B' || c == 'N' || c == 'M'){
            return 3;
        } else {
            throw new RuntimeException("Not Found");
        }
    }

    public static void main(String[] args) {
        Arrays.stream(new T500().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})).forEach(System.out::println);
    }
}
