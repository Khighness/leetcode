package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/19
 * @apiNote 941. 有效的山脉数组
 */

/**
 * Problem:
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 */
public class T941 {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        // state = 1上升趋势，state = 2下降趋势
        int state = 0;
        for (int i = 1; i < arr.length; i++) {
            switch (state) {
                case 0:
                    if (arr[i - 1] >= arr[i]) {
                        return false;
                    } else {
                        state = 1;
                    }
                    break;
                case 1:
                    if (arr[i - 1] == arr[i]) {
                        return false;
                    }
                    if (arr[i - 1] > arr[i]) {
                        state = 2;
                    }
                    break;
                case 2:
                    if (arr[i - 1] <= arr[i]) {
                        return false;
                    }
                    break;
            }
        }
        if (state == 2) {
            return true;
        } else {
            return false;
        }
    }

}
