package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-10-01
 * @apiNote 1385. 两个数组间的距离值
 */
public class T1385 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for (int v1 : arr1) {
            boolean flag = true;
            for (int v2 : arr2)
                if (Math.abs(v2 - v1) <= d) {
                    flag = false;
                    break;
                }
            if (flag) ans++;
        }
        return ans;
    }

}
