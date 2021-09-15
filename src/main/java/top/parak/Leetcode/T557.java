package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-21
 * @apiNote 557. 反转字符串中的单词 III
 */
public class T557 {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            builder.append(reverse(arr[i])).append(' ');
        }
        builder.append(reverse(arr[arr.length - 1]));
        return builder.toString();
    }

    private String reverse(String s) {
        char[] arr = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]);
        }
        return builder.toString();
    }
}
