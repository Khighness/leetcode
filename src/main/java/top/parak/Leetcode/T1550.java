package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-29
 * @apiNote 1550. 存在连续三个奇数的数组
 */
public class T1550 {

    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if ((arr[i] % 2 != 0) && (arr[i+1] % 2 != 0) && (arr[i+2] % 2 != 0)) {
                return true;
            }
        }
        return false;
    }

}
