package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-22
 * @apiNote 1588. 所有奇数长度子数组的和
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

}
