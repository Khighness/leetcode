package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-23
 * @apiNote 1328. 破坏回文串
 */
public class T1328 {

    /**
     * 将回文串分为前半段和后半段，
     * 在前半段中，遇到不为a的字符修改为a返回
     * 前半段字符都为a，那么将后半段最后一个字符改为b
     */
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length(), half = (len - 2) >> 1;
        if (len < 2) return "";
        char[] arr = palindrome.toCharArray();
        for (int i = 0; i <= half; i++) {
            if (arr[i] > 'a') {
                arr[i] = 'a';
                return new String(arr);
            }
        }
        arr[len - 1] = 'b';
        return new String(arr);
    }

}
