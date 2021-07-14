package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-28
 * @apiNote 165. 比较版本号
 */

/**
 * Problem:
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * 返回规则如下：
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 */
public class T165 {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        boolean flag = s1.length > s2.length;
        for (int i = 0; i < (flag ? s2.length : s1.length); i++) {
            int i1 = removeFrontZero(s1[i]);
            int i2 = removeFrontZero(s2[i]);
            if (i1 != i2) return i1 > i2 ? 1 : -1;
        }
        for (int i = (flag ? s2.length : s1.length); i < (flag ? s1.length : s2.length); i++) {
            if (flag && removeFrontZero(s1[i]) != 0) return 1;
            if (!flag && removeFrontZero(s2[i]) != 0) return -1;
        }
        return 0;
    }

    private int removeFrontZero(String s) {
        int index = 0;
        for (index = 0; index < s.length(); index++) {
            if (s.charAt(index) != '0') break;
        }
        if (index == s.length()) return 0;
        return Integer.parseInt(s.substring(index));
    }
}
