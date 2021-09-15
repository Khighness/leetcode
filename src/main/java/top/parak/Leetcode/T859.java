package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-11-30
 * @apiNote 859. 亲密字符串
 */
public class T859 {

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() < 1)  {
            return false;
        }
        int len = A.length();
        // 统计A和B的字母数量
        int[] countA = new int[26], countB = new int[26];
        for (int i = 0; i < len; i++) {
            countA[A.charAt(i) - 'a']++;
            countB[B.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (countA[i] != countB[i]) {
                return false;
            }
        }
        // 如果A==B，那么必须存在一个字母出现大于两次
        if (A.equals(B)) {
            for (int i = 0; i < 26; i++) {
                if (countA[i] > 0) {
                    return true;
                }
            }
            return false;
        }
        // 如果A!=B，那么A和B的异位字母数量必须小于2
        else {
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    count++;
                }
                if (count > 2) {
                    return false;
                }
            }
            return true;
        }
    }

}
