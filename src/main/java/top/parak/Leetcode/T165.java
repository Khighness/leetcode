package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-28
 * @apiNote 165. 比较版本号
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
