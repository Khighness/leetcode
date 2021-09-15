package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-18
 * @apiNote 424. 替换后的最长重复字符
 */
public class T424 {

    /**
     * 滑动窗口
     * 先让窗口扩张(右指针)，一旦窗口不符合替换规则，立即收缩窗口(左指针)
     */
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int left = 0, right = 0;
        int ans = 0, max = 0;
        // 窗口内字符的出现次数
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for (;right < len; right++) {
            int index = arr[right] - 'A';
            count[index]++;
            max = Math.max(max, count[index]);

            // 不符合，收缩窗口

            if (right - left + 1 > max + k) {
                count[arr[left] - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
