package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/27
 * @apiNote 14. 最长公共前缀
 */

/**
 * Problem:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class T14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int k = 1; k < strs.length; k++) {
                if (strs[k].length() <= i) {
                    return stringBuffer.toString();
                }
                if (strs[k].charAt(i) != strs[0].charAt(i)) {
                    return stringBuffer.toString();
                }
            }
            stringBuffer.append(strs[0].charAt(i));
        }
        return stringBuffer.toString();
    }

}
