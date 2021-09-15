package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2021-07-18
 * @apiNote 205. 同构字符串
 */
public class T205 {

    public boolean isIsomorphic(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if ((smap.containsKey(arrS[i]) && smap.get(arrS[i]) != arrT[i])
             || (tmap.containsKey(arrT[i]) && tmap.get(arrT[i]) != arrS[i]))
                return false;
            smap.put(arrS[i], arrT[i]);
            tmap.put(arrT[i], arrS[i]);
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (preIndexOfS[arrS[i]] != preIndexOfT[arrT[i]]) {
                return false;
            }
            preIndexOfS[arrS[i]] = i + 1;
            preIndexOfT[arrT[i]] = i + 1;
        }
        return true;
    }
}
