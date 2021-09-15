package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-15
 * @apiNote 1855. 下标对中的最大距离
 */
public class T1855 {

    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, ans = 0;
        for (int j = 0; j < n2; j++) {
            while (i < n1 && nums1[i] > nums2[j])
                i++;
            if (i < n1) // j - i <= 0时无效
                ans = Math.max(ans, j - i);
        }
        return ans;
    }

}
