package top.parak.Algorithm.Face;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KHighness
 * @since 2021-03-27
 * @apiNote 对于两个字符串，所含有的字符种类完全一样，就将两个字符串算作一类。
 * 输入一批字符串(只包含小写字母)，求字符串出现的种类。
 */
public class HowManyTypes {

    /**
     * 统计出每个字符串出现的摘要字符串（不含重复字符串）
     */
    public int type1(String[] array) {
        Set<String> types = new HashSet<>();
        for (String str : array) {
            char[] chs = str.toCharArray();
            boolean[] map = new boolean[26];
            for (char ch : chs) {
                map[ch - 'a'] = true;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (map[i]) {
                    key.append((char) (i + 'a'));
                }
            }
            types.add(key.toString());
        }
        return types.size();
    }

    /**
     * 使用int的二进制（32）位代表字符串中出现字母的摘要（最多26种，占有26位）
     * 如果题目说字符串为(A-Z，a-z，1-10)，则使用long类型进行位运算
     */
    public int type2(String[] array) {
        Set<Integer> types = new HashSet<>();
        for (String str : array) {
            char[] chs = str.toCharArray();
            int key = 0;
            for (char ch : chs) {
                key |= (1 << (ch- 'a'));
            }
            types.add(key);
        }
        return types.size();
    }

    public static void main(String[] args) {
        String[] array = { "abc", "aabbcc", "aaabbbccc", "abcd" };
        System.out.println(new HowManyTypes().type1(array));
        System.out.println(new HowManyTypes().type2(array));
    }
}
