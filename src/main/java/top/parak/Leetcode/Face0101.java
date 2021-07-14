package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/10/17
 * @apiNote 面试题 01.01. 判定字符是否唯一
 */


/**
 * Problem:
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
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

    public static void main(String[] args) {
        System.out.println(new Face0101().isUnique("leetcode"));
    }

}
