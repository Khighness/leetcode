package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-25
 * @apiNote 1528. 重新排列字符串
 */
public class T1528 {

    public String restoreString(String s, int[] indices) {
        int len = s.length();
        if (len == 1) return s;
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }

}
