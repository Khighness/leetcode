package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/22 22:36
 * @apiNote 1588. 所有奇数长度子数组的和
 */

/**
 * Problem:
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 */

/**
 * Solution:
 * 1.任取数组下标为i(第i+1个)的元素
 * 2.其左边可以取0~i个元素，共i+1种方案，其中(i+1)/2种为奇数，i/2+1种为偶数
 * 3.右边可以取0~(n-i-1)个元素，共n-i种方案，其中(n-i)/2种为奇数，(n-i+1)/2种为偶数
 * 4.合成子数组须满足条件：左边+本身+右边 = 奇数个，故左奇->右奇，左偶->右偶
 * 5.所以arr[i]的出现次数为lOdd X rOdd + lEven X rEven，即左奇X右奇 + 左偶X右偶
 */
public class T1588 {

    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0, n = arr.length;
        int leftOdd, rightOdd, leftEven, rightEven;
        for (int i = 0; i < n; i++) {
            leftOdd = (i + 1) / 2;
            leftEven = i / 2 + 1;
            rightOdd = (n - i) / 2;
            rightEven = (n - i + 1) /2;
            ans += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T1588().sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
    }

}
