package top.parak.Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KHighness
 * @since 2020-09-23
 * @apiNote 771. 宝石与石头
 */
public class T771 {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                ans++;
            }
        }
        return ans;
    }
}
