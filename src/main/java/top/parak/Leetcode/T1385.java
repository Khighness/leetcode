package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/1 17:07
 * @apiNote 1385. 两个数组间的距离值
 */

/**
 * Problem:
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 */
public class T1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr2[j] - arr1[i]) <= d) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans++;
        }
        return ans;
    }
}
