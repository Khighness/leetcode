package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-11-27
 * @apiNote 14. 最长公共前缀
 */
public class T14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int k = 1; k < strs.length; k++) {
                if (strs[k].length() <= i) {
                    return builder.toString();
                }
                if (strs[k].charAt(i) != strs[0].charAt(i)) {
                    return builder.toString();
                }
            }
            builder.append(strs[0].charAt(i));
        }
        return builder.toString();
    }

}
