package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-29
 * @apiNote 880. 索引处的解码字符串
 */
public class T880 {

    // 内存超
    public String decodeAtIndex(String s, int k) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (res.length() >= k) {
                return res.charAt(k - 1) + "";
            }
            if ('2' <= c && c <= '9') {
                int count = c - '0';
                String cur = res.toString();
                for (int i = 0; i < count - 1; i++) {
                    res.append(cur);
                }
            } else {
                res.append(c);
            }
        }
        return res.charAt(k - 1) + "";
    }

    // 计算解码字符串的长度newLen，逆向遍历，当字符串的长度重复d次时，将字符串的长度减少到k/newLen
    public String decodeAtIndex2(String s, int k) {
        int len = s.length();
        long newLen = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if ('2' <= c && c <= '9') {
                newLen *= c - '0';
            } else {
                newLen++;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            char c = arr[i];
            k %= newLen;
            if (k == 0 && 'a' <= c && c <= 'z')
                return Character.toString(c);
            if ('2' <= c && c <= '9') newLen /= c - '0';
            else newLen--;
        }
        return "";
    }

}
