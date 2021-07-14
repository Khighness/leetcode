package top.parak.Leetcode;

/**
 * @author  KHighness
 * @date 2020/9/22 13:26
 * @apiNote 1486. 数组异或操作
 */

/**
 * Problem:
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2 * i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 */

public class T1486 {

    public int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) {
            ans ^= ( 2 * i + start);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T1486().xorOperation(5, 0));
    }

}
