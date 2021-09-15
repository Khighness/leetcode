package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-23
 * @apiNote 1313. 解压缩编码列表
 */
public class T1313 {

    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }
        int[] target = new int[len];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            for (int k = 1; k <= nums[i]; k++) {
                target[index] = nums[i+1];
                index++;
            }
        }
        return target;
    }

}
