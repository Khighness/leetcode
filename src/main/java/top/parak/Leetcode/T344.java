package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-30
 * @apiNote 344. 反转字符串
 */
public class T344 {

    public void reverseString(char[] s) {
        char temp;
        for (int i = 0; i < s.length / 2 ; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

}
