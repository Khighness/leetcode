package top.parak.Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author KHighness
 * @since 2020-10-01
 * @apiNote 500. 键盘行
 */
public class T500 {

    public String[] findWords(String[] words) {
        Set<Integer> set = new HashSet<Integer>();
        List<String> list = new LinkedList<>();
        for (String word : words) {
            String s = word.toUpperCase();
            set.clear();
            for (int j = 0; j < s.length(); j++) {
                int val = getKeyBoardValue(s.charAt(j));
                set.add(val);
            }
            if (set.size() == 1) list.add(word);
        }
        return list.toArray(new String[0]);
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

}
