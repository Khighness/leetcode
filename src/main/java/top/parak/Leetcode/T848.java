package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-18
 * @apiNote 848. 字母移位
 */
public class T848 {

    /**
     * 从后往前遍历
     */
    public String shiftingLetters(String s, int[] shifts) {
        char[] arr = s.toCharArray();
        int curr = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            curr += shifts[i] % 26;
            arr[i] = (char) ((curr + arr[i] - 'a') % 26 + 'a');
        }
        return new String(arr);
    }

}
