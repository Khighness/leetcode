package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-10
 * @apiNote 剑指 Offer 05. 替换空格
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
