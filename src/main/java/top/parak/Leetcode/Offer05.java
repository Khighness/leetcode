package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021/3/10
 * @apiNote 剑指 Offer 05. 替换空格
 */

/**
 * Problem:
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Offer05 {

    public String replaceSpace1(String s) {
        return s.replace(" ", "%20");
    }

    public String replaceSpace2(String s) {
        int numOfSpace = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                numOfSpace++;
            }
        }
        int index = 0;
        char[] array = new char[s.length() + 2 * numOfSpace];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[index++] = '%';
                array[index++] = '2';
                array[index++] = '0';
            } else {
                array[index++] = c;
            }
        }
        return new String(array);
    }
}
