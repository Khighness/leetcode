package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-10-17
 * @apiNote 面试题 01.01. 判定字符是否唯一
 */
public class Face0101 {

    public boolean isUnique(String astr) {
        int[] count = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            count[astr.charAt(i) - 'a']++;
        }
        //Arrays.stream(count).forEach(System.out::println);
        for (int i = 0; i < 26; i++) {
            if (count[i] >= 2) {
                return false;
            }
        }
        return true;
    }

}
